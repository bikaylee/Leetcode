class Solution {
    public int numWays(int n, int k) {
        // if(n == 0 || k == 0 || (n > 2 && k == 1))
        //     return 0;
        // else if(n == 1)
        //     return k;
        // else if(n == 2)
        //     return (int) Math.pow(k, 2);
        if (n == 0) 
            return 0;
        if (n == 1) 
            return k;
        
        
        int [] dp = new int[n+1];
        dp[1] = k;
        dp[2] = (int) Math.pow(k, 2);
        
        for(int i = 3; i <= n; i++)
            dp[i] = (dp[i-1]+dp[i-2])*(k-1);
        
        return dp[n];
        
        // K = 4
        // n = 0: 0
        // n = 1: 4
        // n = 2: 16
        // n = 3: 60
        // n = 4: 228
        // n = 5: 864
        // n = 6: 3276
        // n = 7: 12420
        
        //K = 3
        // n = 0: 0
        // n = 1: 3 -> 1x3  2^1 x 3
        // n = 2: 9 -> 3x3  
        // n = 3: 24 -> 7x3
        // n = 4: 66 -> 22x3
        // n = 5: 180 -> 60x3
        // n = 6: 492 -> 164x3
        // n = 7: 1344 -> 448x3
        // n = 8: 3672 -> 1224x3
        // n = 9: 10032 -> 3344x3
        
        
        // K = 2
        // n = 0: 0
        // n = 1: 2
        // n = 2: 4
        // n = 3: 6
        // n = 4: 10
        // n = 5: 16
        // n = 6: 26
        // n = 7: 42
    }
}