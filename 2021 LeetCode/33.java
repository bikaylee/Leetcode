// 33. Search in Rotated Sorted Array

/*
Instead of going through the input array in two passes, we could achieve the goal in one pass with an revised binary search.

    Initiate the pointer start to 0, and the pointer end to n - 1.
    Perform standard binary search. While start <= end:
        Take an index in the middle mid as a pivot.
        If nums[mid] == target, the job is done, return mid.
        Now there could be two situations:
            1. Pivot element is larger than the first element in the array, i.e. the subarray from the first element to the pivot is non-rotated, as shown in the following graph.
                 - If the target is located in the non-rotated subarray:
                        go left: `end = mid - 1`.
                - Otherwise: go right: `start = mid + 1`.
            2. Pivot element is smaller than the first element of the array, i.e. the rotation index is somewhere between 0 and mid. It implies that the sub-array from the pivot element to the last one is non-rotated, as shown in the following graph.
                - If the target is located in the non-rotated subarray:
                        go right: `start = mid + 1`.
                - Otherwise: go left: `end = mid - 1`.
*/


class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (nums[lo] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}