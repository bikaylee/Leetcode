class Solution {
    // - Use hash table to store the frequency of all unique characters in a string.
    // Then, sort each unique characters in the return string.

    // Time: O(n log n)
    // Space: O(n)
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        for (char c : freq.keySet())
            pq.add(c);

        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < freq.get(c); i++)
                res.append(c);
        }

        return res.toString();
    }
}
