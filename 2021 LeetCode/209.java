// 209. Minimum Size Subarray Sum

class Solution {

    // the window size is not fixed
    // minimize the window by moving the left pointer

    // Keep a running total of the current window
    // compare with the target value
    // if running total >= target
    // update the minimum len
    // and shorten the window to check for smaller window size

    // if the len == its initial value, meaning no subarray is found >= target
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;

        int currSum = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            currSum += nums[right];

            while (currSum >= target) {
                len = Math.min(right - left + 1, len);
                currSum -= nums[left++];
            }
        }

        return (Integer.MAX_VALUE == len) ? 0 : len;
    }
}