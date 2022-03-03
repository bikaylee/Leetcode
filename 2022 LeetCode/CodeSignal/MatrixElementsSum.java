package CodeSignal;

public class MatrixElementsSum {
    int solution(int[][] matrix) {

        int ans = 0;
        // traverse vertically, so any vertically room is 0 then entire column should be
        // ignored
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                if (matrix[r][c] == 0)
                    break;
                else
                    ans += matrix[r][c];
            }
        }

        return ans;
    }

}
