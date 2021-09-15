// 1877. Minimize Maximum Pair Sum in Array

class Solution {
    public int minPairSum(int[] nums) {
        // Find the minimum sum in pair sum
        // then compare all pair sum

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int maxPairSum = Integer.MIN_VALUE;
        while (left < right) {
            int pairSum = nums[left++] + nums[right--];
            maxPairSum = Math.max(maxPairSum, pairSum);
        }

        return maxPairSum;
    }
}