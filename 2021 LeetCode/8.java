// 8. String to Integer (atoi)

class Solution {
    public int myAtoi(String s) {

        // remove all leading spaces
        s = s.trim();
        if (s.length() == 0)
            return 0;

        int firstChar = s.charAt(0);

        int sign = 1;
        int start = 0;
        int end = 0;

        // if the first character is not sign, then its cannot be an integer
        if (!Character.isDigit(firstChar)) {
            if (firstChar == '-') {
                sign *= -1;
                start = 1;
            } else if (firstChar == '+')
                start = 1;
            else
                return 0;
        }

        // Find the last position of the integer
        for (end = start; end < s.length(); end++) {
            if (!Character.isDigit(s.charAt(end))) {
                break;
            }
        }

        long ans = 0;
        for (int i = start; i < end; i++) {
            ans = ans * 10 + (s.charAt(i) - '0');
            if (ans > (long) Integer.MAX_VALUE) {
                if (sign == -1 && ans >= (long) Integer.MAX_VALUE + 1)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
        }

        return (int) ans * sign;
    }
}
