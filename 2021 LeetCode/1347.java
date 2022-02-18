// 1347. Minimum Number of Steps to Make Two Strings Anagram

class Solution {
    public int minSteps(String s, String t) {

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        int steps = 0;
        for (int i = 0; i < 26; i++) {
            // System.out.println((char) (i + 'a') + ": " + count[i]);
            if (count[i] > 0)
                steps += count[i];
        }

        return steps;
    }
}