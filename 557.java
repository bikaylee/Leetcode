// 557. Reverse Words in a String III

class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                ans.append(reverse(s, start, i));
                ans.append(" ");
                start = i + 1;
            }
        }
        ans.append(reverse(s, start, s.length()));
        return ans.toString();
    }

    private StringBuilder reverse(String s, int start, int end) {
        StringBuilder sb = new StringBuilder(s.substring(start, end));
        return sb.reverse();
    }
}