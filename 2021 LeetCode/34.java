//34. Find First and Last Position of Element in Sorted Array

class Solution {

    /*
      The key is to find first occurrence and last occurrence separately. 
      First: 
      if meets the target: 
           mark current index and
           minimize the range and keep looking for the occurrence in the left half of every sub-range 
      else: 
           same as normal binary search to minimize the range for the target value 
      Last: 
      if meets the target: 
           same with first, but keep looking for the right size util there's no occurence shows 
     */

    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                hi = mid - 1;
                first = mid;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                lo = mid + 1;
                last = mid;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return new int[] { first, last };
    }
}
