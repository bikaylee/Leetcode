class Solution {
    // Time: O(J.length+S.length)
    // Space: O(J.length)
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewel = new HashSet<>();

        for (char c : jewels.toCharArray())
            jewel.add(c);

        int count = 0;
        for (char c : stones.toCharArray())
            count += jewel.contains(c) ? 1 : 0;

        return count;
    }
}