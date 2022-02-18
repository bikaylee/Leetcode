// 1277. Count Square Submatrices with All Ones

class Solution {
    public int countSquares(int[][] matrix) {
        // In order to validate a square, check for its left, top, top-left
        // get their minimum + 1 and reflect on current element if it's 1

        // 0,1,1,1
        // 1,1,1,1
        // 0,1,1,1

        // 0,1,1,1=3
        // 1,1,2,2=6
        // 0,1,2,3=6

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && i > 0 && j > 0)
                    matrix[i][j] = Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i][j - 1])) + 1;
                count += matrix[i][j];
            }
        }

        return count;
    }
}