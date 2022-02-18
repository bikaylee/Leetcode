//7. Reverse Integer
/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 

Constraints:

-2^31 <= x <= 2^31 - 1
*/

class Solution {
    public int reverseStack(int x) {

        boolean negative = x < 0;
        Stack<Integer> st = new Stack();
        x = Math.abs(x);

        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            st.add(digit);
        }

        int ans = 0;
        for (int i = 0; !st.isEmpty(); i++) {
            ans += st.pop() * Math.pow(10, i);
        }

        if (ans >= Integer.MAX_VALUE - 1)
            return 0;

        return negative ? -ans : ans;
    }

    public int reverse(int x) {
        boolean neg = x < 0 ? true : false;

        x = Math.abs(x);

        int ans = 0;
        while (x > 0) {
            int t = x % 10;
            x /= 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && t > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && t < -8))
                return 0;
            ans = ans * 10 + t;
        }
        ans *= neg ? -1 : 1;
        return ans;
    }
}