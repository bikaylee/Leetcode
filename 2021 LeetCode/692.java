class Solution {
    // - Use hash map to store frequency of all words. Then, use a priority queue to
    // compare each frequency until k elements are added to the return list.

    // Time: O(n log n)
    // Space: O(n)
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();

        for (String word : words)
            freq.put(word, freq.getOrDefault(word, 0) + 1);

        PriorityQueue<String> pq = new PriorityQueue<>(
                (s1, s2) -> freq.get(s1) == freq.get(s2) ? s1.compareTo(s2) : freq.get(s2) - freq.get(s1));
        for (String word : freq.keySet())
            pq.add(word);

        List<String> ans = new ArrayList<String>();
        while (!pq.isEmpty() && k-- > 0)
            ans.add(pq.poll());

        return ans;
    }
}