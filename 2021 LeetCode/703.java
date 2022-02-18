// - Maintain a min heap so that its first element is the kth largest

// - Deque the smallest element when queue size is greater than or equal to k, then add the new element to always maintain k elements in queue

class KthLargest {
    // k = 3
    // Input: 4, 5, 8, 2
    // Sorted: 2 4 5 8
    // add(3): 2 3 4 5 8 -> 4
    // add(5): 2 3 4 5 5 8 -> 5
    // add(10): 2 3 4 5 5 8 10 -> 5
    // add(9): 2 3 4 5 5 8 9 10 -> 8
    // add(4): 2 3 4 4 5 5 8 9 10 -> 8

    private final int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>(k);
        this.k = k;
        for (int num : nums) {
            this.add(num);
        }
    }

    // Time: O(k log k)
    // Space: O(k)
    public int add(int n) {
        // System.out.println(q.toString());
        if (this.pq.size() < this.k) {
            this.pq.add(val);
        } else if (this.pq.peek() < val) {
            this.pq.poll();
            this.pq.add(val);
        }
        return this.pq.peek();
    }
}