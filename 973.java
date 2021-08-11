class Solution {
    // - Use the max heap to do the sorting of distance of each points, `(p1, p2)`
    // where `((p2_x)^2 + (p2_y)^2) < ((p1_x)^2 + (p1_y)^2)`

    // - represent in lambda express: `(p2_x)^2 + (p2_y)^2 - ((p1_x)^2 + (p1_y)^2)`
    // - `(p1, p2) -> (p2_x)^2 + (p2_y)^2 - (p1_x)^2 - (p1_y)^2`

    // - To keep the sorting in `log k`, when the number of points in queue has
    // reaches `k`, deque the biggest
    // - Put points into return array in reversed order

    // Time: O(n log k)
    // Space: O(k)
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        Queue<int[]> pq = new PriorityQueue<int[]>(
                (p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k)
                pq.poll();
        }
        while (k > 0)
            ans[--k] = pq.poll();
        return ans;
    }

}
