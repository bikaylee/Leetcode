class Solution {
    // Time: O(n)
    // Space: O(n)
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int longest = 0;
        for (int i = 0, start = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                start = Math.max(map.get(c), start);
            longest = Math.max(longest, i - start + 1);
            map.put(c, i + 1);
        }
        return longest;
    }
}