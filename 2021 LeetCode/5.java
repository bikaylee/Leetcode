// 5. Longest Palindromic Substring

class Solution {
    /**
     * In order to find one of the substring to be a palindrome, 1. n^3 Brute Force
     * - go over each possible substring (TLE) 2. n^2 Expansion from Middle -
     * Iterate through each position at s and expand itself to left and right - once
     * possible expansion is found, then return the length of the substring - Two
     * case to take care: 1. have middle char that's unique with an ODD length 2.
     * does not have a middle char with an EVEN length - keep updating the starting
     * position and end position of the palindrome
     */

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int even = expand(s, i, i);
            int odd = expand(s, i, i + 1);
            int len = Math.max(even, odd);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // r-l-1 because r and l reach one move extra toward left and right
        // supposed to be (right - left + 1) but since the while checks for after
        // they're been inc/dec
        return right - left - 1;
    }

    // Brute Force
    public String longestPalindromeBruteForce(String s) {
        if (s == null || s.length() <= 1)
            return s;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j)) && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end);
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
}