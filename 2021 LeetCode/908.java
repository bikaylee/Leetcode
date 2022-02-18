// 908. Smallest Range I

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];

        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        // (max-k) - (min+k) = max-min-2*k
        return Math.max(0, (max - k) - (min + k));
    }
}
