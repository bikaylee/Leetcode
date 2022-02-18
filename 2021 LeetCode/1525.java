class Solution {
    public int numSplits(String s) {
        int goodSplits = 0;

        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();

        for (char c : s.toCharArray())
            right.put(c, right.getOrDefault(c, 0) + 1);

        // perform paritions of left and right substring by counting the freq of letters
        // if the number of unique letters are the same, then it's a good split.
        for (char c : s.toCharArray()) {
            left.put(c, left.getOrDefault(c, 0) + 1);
            right.put(c, right.getOrDefault(c, 1) - 1);
            if (right.get(c) == 0)
                right.remove(c);

            if (right.size() == left.size())
                goodSplits++;
        }

        return goodSplits;
    }
}