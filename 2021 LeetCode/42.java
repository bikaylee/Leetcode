// 42. Trapping Rain Water

class Solution {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;
        int max = 0;
        int n = height.length;
        int maxHeight = 0;

        int[] dp = new int[n];

        for (int i = 1; i < n - 1; i++) {
            if (height[i] >= height[maxHeight])
                maxHeight = i;
            int prev = dp[i - 1] + height[i - 1];
            if (height[i] < prev) {
                dp[i] = prev - height[i];
                max += dp[i];
            }
        }

        int i = n - 1;
        int second = height[i];
        while (i > maxHeight && height[i - 1] + dp[i - 1] >= height[i]) {
            second = Math.max(second, height[i]);
            max -= dp[i - 1] - (second > height[i - 1] ? second - height[i - 1] : 0);
            i--;
        }

        return max;
    }
}
