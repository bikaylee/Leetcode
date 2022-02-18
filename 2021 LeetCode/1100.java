// 1100. Find K-Length Substrings With No Repeated Characters

class Solution {

    public int numKLenSubstrNoRepeats(String s, int k) {
        if (s.length() < k)
            return 0;

        int ans = 0;
        HashSet<Character> seen = new HashSet<>();

        // At every character, add to hashset
        for (int i = 0, j = 0; j < s.length(); j++) {

            // if repeated letter is found
            // remove all letters before it and itself
            // in order to look for a new subset of string
            while (seen.contains(s.charAt(j)))
                seen.remove(s.charAt(i++));
            seen.add(s.charAt(j));

            // current window size
            // or change seen.size() to (j-i+1)
            ans += seen.size() >= k ? 1 : 0;
        }

        return ans;
    }

    // Brute Force
    public int numKLenSubstrNoRepeats(String s, int k) {
        int n = s.length();
        if (n < k)
            return 0;

        int ans = 0;
        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            seen.clear();
            for (int j = i; j - i < k; j++)
                seen.add(s.charAt(j));
            ans += seen.size() == k ? 1 : 0;
        }
        return ans;
    }
}