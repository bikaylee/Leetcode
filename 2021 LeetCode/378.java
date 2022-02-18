// 378. Kth Smallest Element in a Sorted Matrix

class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                pq.add(matrix[r][c]);
            }
        }

        while (k > 1) {
            // System.out.println(pq.poll());
            pq.poll();
            k--;
        }

        return pq.poll();
    }
}