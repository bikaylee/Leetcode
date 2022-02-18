// 542. 01 Matrix

class Solution {

    // BFS, use all zeros to update their nearest and add its neighbors
    // to find new neighbors that haven't been visited and not zero

    // Start from 0, search all neighbors and update, put its neighbors in
    // Start from 1, search all neighbors and update, put its neighbors in
    // ex, particular 1 surrounded by all 1's 4-directionally, so its value should
    // be updated to 2
    public int[][] updateMatrixBFS(int[][] mat) {
        int[][] ans = mat.clone();

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0)
                    queue.add(new Pair(r, c));
                else
                    ans[r][c] = Integer.MAX_VALUE;
            }
        }
        // System.out.println(queue.toString());

        int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();
            int currR = curr.getKey();
            int currC = curr.getValue();

            for (int i = 0; i < 4; i++) {
                int r = currR + dir[i][0];
                int c = currC + dir[i][1];
                if (r >= 0 && c >= 0 && r < ans.length && c < ans[0].length && ans[r][c] > ans[currR][currC]) {
                    ans[r][c] = ans[currR][currC] + 1;
                    queue.add(new Pair(r, c));
                }
            }
        }
        return ans;
    }

    final int max = Integer.MAX_VALUE - 100000;

    // Two passes to update the distance
    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;
        int[][] ans = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                ans[i][j] = max;

        // LEFT UP
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0)
                    ans[r][c] = 0;
                else {
                    int left = max;
                    int up = max;
                    if (r > 0)
                        up = ans[r - 1][c];
                    if (c > 0)
                        left = ans[r][c - 1];
                    ans[r][c] = Math.min(ans[r][c], Math.min(up, left) + 1);
                }
            }
        }

        // RIGHT DOWN
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (mat[r][c] == 0)
                    ans[r][c] = 0;
                else {
                    int right = max;
                    int down = max;
                    if (r + 1 < rows)
                        down = ans[r + 1][c];
                    if (c + 1 < cols)
                        right = ans[r][c + 1];
                    ans[r][c] = Math.min(ans[r][c], Math.min(down, right) + 1);
                }
            }
        }

        return ans;
    }

}