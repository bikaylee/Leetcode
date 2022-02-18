package CodeSignal;

public class RotateImage {
    int[][] solution(int[][] matrix) {

        int n = matrix.length;

        // transpose the matrix
        // reverse by the diagonal lefttop to bottom right
        // [[1, 2, 3], [[1, 4, 7],
        // [4, 5, 6], => [2, 5, 8],
        // [7, 8, 9]] [3, 6, 9]]
        for (int r = 0; r < n; r++) {
            for (int c = r; c < n; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

        // reverse it between rows
        // [[1, 2, 3], [[7, 4, 1],
        // [4, 5, 6], => [8, 5, 2],
        // [7, 8, 9]] [9, 6, 3]]
        for (int r = 0; r < n; r++) {
            int i = 0, j = n - 1;
            while (i < j) {
                int temp = matrix[r][i];
                matrix[r][i] = matrix[r][j];
                matrix[r][j] = temp;
                i++;
                j--;
            }
        }

        return matrix;
    }

}
