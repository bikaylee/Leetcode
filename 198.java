class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) 
            return 0;
        else if(nums.length == 1)
            return nums[0];
        else if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        else
        {
            int [] dp = new int[nums.length+1];
            dp[0] = 0;
            dp[1] = nums[0];
            dp[2] = nums[1];
            
            int ans = Math.max(dp[1], dp[2]);

            for(int i = 3; i <= nums.length; i++)
            {
                dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-3] + nums[i-1]);
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
}