// 125. Valid Palindrome

class Solution {
    public boolean isPalindrome(String s) {

        // s = s.replaceAll("[\\W]|_", "").toLowerCase();
        // int start = 0, end = s.length()-1;

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }
        return true;
    }
}