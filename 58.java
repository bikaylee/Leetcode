// 58. Length of Last Word

class Solution {
    public int lengthOfLastWord(String s) {
        // String [] tok = s.split(" ");
        // return tok.length > 0 ? tok[tok.length-1].length():0;

        int end = s.length() - 1;
        while (s.charAt(end) == ' ' && end > 0) {
            end--;
        }
        for (int i = end; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                return end - i;
        }
        return end + 1;
    }
}