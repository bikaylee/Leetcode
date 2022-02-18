class Solution {
    // - Same idea as 973. K Closest Points to Origin

    // Time: O(n log k)
    // Space: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums)
            freq.put(n, freq.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
        for (int n : freq.keySet()) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] elements = new int[k];
        while (k > 0) {
            elements[--k] = pq.poll();
        }
        return elements;
    }
}
