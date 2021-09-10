/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint 
stopping you from robbing each of them is that adjacent houses have 
security system connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount 
of money of each house, determine the maximum amount of money you 
can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
*/

class Solution {

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        // adjacent house must not be included
        // memorized all sub-optimal maximum amount
        // sub-optimal is defined to include the max(i-2, i-3) since i-1 is excluded

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = nums[1];

        for (int i = 3; i <= nums.length; i++)
            dp[i] = nums[i - 1] + Math.max(dp[i - 2], dp[i - 3]);

        return Math.max(dp[n], dp[n - 1]);
    }

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        else {
            int[] dp = new int[nums.length + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            dp[2] = nums[1];

            int ans = Math.max(dp[1], dp[2]);

            for (int i = 3; i <= nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 3] + nums[i - 1]);
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
}