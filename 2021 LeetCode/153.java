// 153. Find Minimum in Rotated Sorted Array

class Solution {
    // [4, 5, 6, 7, 0, 1, 2]
    // ^ ^ ^
    // low mid high

    // if nums[mid] > nums[high]
    // // means nums has been rotated < n times
    // move low to mid until nums[mid] < nums[high] // sorted order
    // else:
    // move high to mid as it approaches the minimum

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high])
                // we can only have low = mid+1
                // because in this case nums[mid] is never the minimum
                // and we need to shorten the range of the smaller subarray
                low = mid + 1;
            else
                high = mid;
        }
        return nums[high];
    }

    // [4, 5, 6, 0, 1, 2, 3]
    // ^ ^ ^
    // low mid high

    // nums[mid] < nums[low] -> low = mid;
    // nums[mid] > nums[low] -> high = mid-1;

    // NOT WORKING, since we always want to find out the rightmost
    // to check if it's rotated
    public int findMinNOTWORKING(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[low])
                low = mid;
            else
                high = mid - 1;
        }

        return nums[low];
    }
}