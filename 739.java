class Solution {
    // #### Approach 1: (Brute Force)
    // - Check each element's next warmer day

    // Time: O(n^2)
    // Space: O(1)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }

    // #### Approach 2: (Monotonic Stack)

    // - Similar to [907. Sum of Subarray Minimums](#907-Sum-of-Subarray-Minimums)
    // - Monotonic Stack that keeps decreasing elements from bottom to top

    // Time: O(n)
    // Space: O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        Deque<Integer> maxStack = new ArrayDeque<>(); // keep a decreasing stack from bottom to top
        // Stack<Integer> maxStack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!maxStack.isEmpty() && temperatures[maxStack.peekFirst()] <= temperatures[i])
                maxStack.pollFirst();
            ans[i] = maxStack.isEmpty() ? 0 : maxStack.peekFirst() - i;
            maxStack.push(i);
        }
        return ans;
    }

    // #### Approach 3: (Dynamic Programming)

    // - Use extra dp array to store all the next warmer day difference
    // Time: O(n)
    // Space: O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < n) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                }
                // if current range(i, n) is decreasing, there is no warmer temp than temp[i]
                else if (ans[j] == 0)
                    break;
                // it implies that temp[j] <= temp[i] and temp[j] had been taken care,
                // so the number larger than temp[j] must be temp[ans[j]]
                else
                    j += ans[j];
            }
        }
        return ans;
    }
}