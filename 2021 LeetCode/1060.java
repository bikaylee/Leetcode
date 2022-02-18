// 1060. Missing Element in Sorted Array

class Solution {
    public int missingElement(int[] nums, int k) {
        int i = 1;
        for (; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1] - 1;
            if (k > diff)
                k -= diff;
            else
                return nums[i - 1] + k;
        }
        return nums[i - 1] + k;
    }
}