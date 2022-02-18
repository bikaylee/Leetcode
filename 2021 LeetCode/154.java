// 154. Find Minimum in Rotated Sorted Array II

class Solution {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Cannot decide which part to eliminate,
            // Then it will be a linear search for contains all duplicates
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                high--;
                low++;
            } else if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low];
    }
}