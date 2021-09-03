// 542. 01 Matrix

class Solution {
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