/*
There is a fence with n posts. Each post can be painted with one of the k colors. 
You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Given the two integers n and k, return the total number of ways you can paint the fence.

Example 1:
Input: n = 3, k = 2
Output: 6
Explanation: All the possibilities are shown.

Example 2:
Input: n = 1, k = 1
Output: 1


Constraints:
1 <= n <= 50
1 <= k <= 105
The answer is guaranteed to be in the range [0, 231 - 1] for the given n and k.
*/

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