// 674. Longest Continuous Increasing Subsequence

class Solution {

    // whenever that element is not increasing
    // calculate the interval range of the increasing elements
    public int findLengthOfLCIS(int[] nums) {
        int length = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            if (nums[end - 1] >= nums[end]) {
                length = Math.max(length, end - start);
                start = end;
            }
            end++;
        }
        return Math.max(length, end - start);
    }
}