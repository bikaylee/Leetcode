// 1299. Replace Elements with Greatest Element on Right Side

class Solution {

    // Straight forward - 10-5-2021
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = -1;
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        return arr;
    }

    // Monotonic Stack - 10-5-2021
    public int[] replaceElements(int[] arr) {

        int n = arr.length;
        Stack<Integer> monoStack = new Stack();

        for (int i = n - 1; i > 0; i--) {
            if (monoStack.isEmpty() || arr[i] > arr[monoStack.peek()])
                monoStack.add(i);
        }

        for (int i = 0; i < n - 1; i++) {
            if (i >= monoStack.peek())
                monoStack.pop();
            arr[i] = arr[monoStack.peek()];
        }

        arr[n - 1] = -1;
        return arr;
    }
}