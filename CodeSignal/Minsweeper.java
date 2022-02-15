package CodeSignal;

public class Minsweeper {
    int[][] solution(boolean[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] ans = new int[n][m];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int neighbors = 0;

                if (r - 1 >= 0) {
                    neighbors += matrix[r - 1][c] ? 1 : 0;
                    if (c - 1 >= 0)
                        neighbors += matrix[r - 1][c - 1] ? 1 : 0;
                    if (c + 1 < m)
                        neighbors += matrix[r - 1][c + 1] ? 1 : 0;
                }

                if (c - 1 >= 0)
                    neighbors += matrix[r][c - 1] ? 1 : 0;
                if (c + 1 < m)
                    neighbors += matrix[r][c + 1] ? 1 : 0;

                if (r + 1 < n) {
                    neighbors += matrix[r + 1][c] ? 1 : 0;
                    if (c - 1 >= 0)
                        neighbors += matrix[r + 1][c - 1] ? 1 : 0;
                    if (c + 1 < m)
                        neighbors += matrix[r + 1][c + 1] ? 1 : 0;
                }

                ans[r][c] = neighbors;
            }
        }

        return ans;
    }

}
