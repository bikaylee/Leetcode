// 415. Add Strings
class Solution {
    public String addStrings(String num1, String num2) {
        // Map<Character, Integer> map = new HashMap<>() {{
        // put('0', 0);
        // put('1', 1);
        // put('2', 2);
        // put('3', 3);
        // put('4', 4);
        // put('5', 5);
        // put('6', 6);
        // put('7', 7);
        // put('8', 8);
        // put('9', 9);
        // }};

        StringBuilder sb = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}