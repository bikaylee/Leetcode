class Solution {
    // - Define a priority queue, where each pair has to be
    // - `[a0, b0], [a1, b1]`: `a` is the index of A and `b` is the index of B
    // - `A[a0] + B[b0]` > `A[a1] + B[b1]`

    // - Trace:
    // - PQ initial state: `[[1, 2], [7, 2], [11, 2]]`
    // - return list: deque PQ of `[1, 2]` must be the smallest (index of `(0,0)`)
    // - Expand the index in B array: PQ = `[[1, 4], [7, 2], [11, 2]]`
    // - return list: deque PQ of `[1, 4]` (index of `(0, 1)`)
    // - Expand the index in B array: PQ = `[[1, 6], [7, 2], [11, 2]]`
    // - return list: deque PQ of `[1, 6]` (index of `(0, 2)`)
    // - Since `2` is the last index in B, do not add new pair to array
    // - return list: deque PQ of `[7, 2]` (index of `(1, 0)`)
    // - Expand the index in B array: PQ = `[[7, 4], [11, 2]]`

    // - the number of pairs in priority will always be <= N (size of A), so it will
    // only compare in `log n` for `n` pairs

    // Time: O(n log n)
    // Space: O(n)
    public List<List<Integer>> kSmallestPairs(int[] A, int[] B, int k) {

        // Edge Case: either array is empty or k is 0
        if (A == null || B == null || A.length == 0 || B.length == 0 || k <= 0) {
            return new ArrayList<>();
        }

        final int N = A.length;
        final int M = B.length;

        // Set up priority queue that only need to memorized the index in array A and B
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> A[a[0]] + B[a[1]] - A[b[0]] - B[b[1]]);

        // Initialize each pair to all element in A and first element in B
        // In the first time, (0th element in A, 0th element in B) must be the smallest
        // pair
        // Then, push new elements of first in queue's A element index and B element
        // index +1
        // to compare the (ith element in A, j+1 th element in B) which will always
        // deque the sub-optimal pair
        for (int i = 0; i < N; i++) {
            pq.add(new int[] { i, 0 });
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] p = pq.poll();
            ans.add(Arrays.asList(A[p[0]], B[p[1]]));
            if (p[1] + 1 < M) {
                pq.add(new int[] { p[0], p[1] + 1 });
            }
        }
        return ans;
    }

}
