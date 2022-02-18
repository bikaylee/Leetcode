class Solution {
    /*
     * - Array of `min` to store the current minimum so far until meets a new
     * minimum and set the rest of the array with the new min
     * 
     * - Use a stack to find the `nums[k]` and `nums[j]` and start with the end of
     * the input array
     * 
     * - Since the `min` array stores `nums[i]`
     * 
     * - Every element that pushes to the stack will be less than the `min` and
     * elements that less than or equal to `min` will be popped
     * 
     * - If the current element is greater than the top of the stack, then **132
     * pattern** is found where `min[i](1) < stack.top(2) < nums[i](3)`
     */

    // Time: O(n)
    // Space: O(n)
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > min[i]) {
                while (!stack.isEmpty() && stack.peek() <= min[i])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[i])
                    return true;
                stack.push(nums[i]);
            }
        }
        return false;
    }

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> d = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k)
                return true;
            while (!d.isEmpty() && d.peekLast() < nums[i]) {
                k = Math.max(k, d.pollLast());
            }
            d.addLast(nums[i]);
        }
        return false;
    }
}
