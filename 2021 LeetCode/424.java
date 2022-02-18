// 424. Longest Repeating Character Replacement

class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int maxLength = 0;
        int maxCount = 0;

        // Get the most frequent letter and check window size - freqOfLetter
        // is less than possible k letter changes, then remove the left
        // letter from window
        for (int i = 0, start = 0; i < s.length(); i++) {
            maxCount = Math.max(maxCount, ++freq[s.charAt(i) - 'A']);

            while (i + 1 - start - maxCount > k)
                freq[s.charAt(start++) - 'A']--;
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}