// 704. Binary Search

class Solution {

    // [Low, High]
    public int searchInclusive(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;

            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return -1;
    }

    // [Low, high)
    public int searchExclusive(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                hi = mid;
            else
                lo = mid + 1;
        }

        return -1;
    }
}