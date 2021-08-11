class Solution {
    // - Iterating the sequence of digits from left to right, the main loop can be
    // broken down as follows:

    // 1. for each digit, if the digit is less than the top of the stack, i.e. the
    // left neighbor of the digit, then we pop the stack, i.e. removing the left
    // neighbor. At the end, we push the digit to the stack.

    // 2. we repeat the above step (1) until any of the conditions does not hold any
    // more, e.g. the stack is empty (no more digits left). or in another case, we
    // have already removed k digits, therefore mission accomplished.

    // By the code below:

    // 1. Remove all left elements that are greater than the right element until `k`
    // is 0 or reaches the end of the string

    // 2. If there's any `k` left, remove the `k items` from the stack since the
    // stack should be increasing from bottom to top

    // 3. Now, all `k` has been removed, the last step is to remove any leading
    // zeros

    // Time: O(n)
    // Space: O(n)
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : num.toCharArray()) {
            // only pop the ones that are larger than the next
            if (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        /* remove the remaining digits from the tail. */
        for (int i = 0; i < k; ++i) {
            stack.pop();
        }

        /// build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0')
                continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string */
        if (ret.length() == 0)
            return "0";
        return ret.toString();
    }
}
