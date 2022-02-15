package CodeSignal;

public class BoxBlur {
    int[][] solution(int[][] image) {

        int n = image.length, m = image[0].length;

        int[][] ans = new int[n - 2][m - 2];

        for (int i = 2; i < n; i++) {
            for (int j = 2; j < m; j++) {
                int sum = 0;
                for (int r = i - 2; r <= i; r++) {
                    for (int c = j - 2; c <= j; c++) {
                        sum += image[r][c];
                    }
                }
                ans[i - 2][j - 2] = sum / 9;
            }
        }

        return ans;
    }

}