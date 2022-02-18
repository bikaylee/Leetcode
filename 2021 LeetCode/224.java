class Solution {
    /*
     * - Intuition: Using stack to store current sum and calculator the sub-problem
     * sum in the parenthese
     * 
     * 1. Stack holds integers and sign in front of the parenthese
     * 
     * 2. Within the parenthese, same idea of keeping the sign before an integer
     * 
     * 2.1. When reaches the opening paren `(`, push current sum and its sign before
     * `(` to the stack. Because we are using current `sum` variable to solve
     * current subproblems.
     * 
     * 2.2. When reaches the end of the parenthese `)`, then solve the current
     * problem by popping off the most current sum off the stack along with its
     * addition or subtraction. Lastly, update the `sum` variable until seeing the
     * next parenthese.
     * 
     * 3. Since an integer might not be a single digit integer, find all of its
     * values by using `operand = 10 * operand + (int) (ch - '0')` where `operand`
     * will be initially zero.
     * 
     * 4. Finally, the result will be `sum + (sign * operand)`.
     */

    public int calculate(String s) {

        Stack<Integer> stack = new Stack();
        int ans = 0;
        int sign = 1;
        int operand = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } else if (c == ')') {
                ans += sign * operand;
                ans *= stack.pop();
                ans += stack.pop();
                operand = 0;
            } else if (c == '+') {
                ans += sign * operand;
                sign = 1;
                operand = 0;
            } else if (c == '-') {
                ans += sign * operand;
                sign = -1;
                operand = 0;
            } else if (Character.isDigit(c)) {
                operand = 10 * operand + (c - '0');
            }
        }

        return ans + (sign * operand);
    }
}
