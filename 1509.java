class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length - 1;

        // If we've change all elements in the array, the min and max must be itself
        if (n < 4)
            return 0;

        Arrays.sort(nums);

        // Four different ways to do the moves
        // 1. change the first three nums
        // 2. change the last three nums
        // 3. change 1 on left and 2 on right
        // 4. change 2 on left and 1 on right
        int removeFirstLastEvenly = Math.min(nums[n] - nums[3], nums[n - 3] - nums[0]);
        int removeFirstLastUnEvenly = Math.min(nums[n - 1] - nums[2], nums[n - 2] - nums[1]);
        return Math.min(removeFirstLastEvenly, removeFirstLastUnEvenly);
    }
}
