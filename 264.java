class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int two = 2, three = 3, five = 5;
        for (int i = 1, x = 1, y = 1, z = 1; i < n; i++) {
            int min = Math.min(two, Math.min(three, five));
            dp[i] = min;
            if (min == two)
                two = dp[x++] * 2;
            if (min == three)
                three = dp[y++] * 3;
            if (min == five)
                five = dp[z++] * 5;
        }

        return dp[n - 1];
    }
}