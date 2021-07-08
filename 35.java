// 35. Search Insert Position

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;

        while (low < high) {
            int mid = (high - low) / 2 + low;

            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                high = mid;
            else
                low = mid + 1;
        }

        // System.out.println("\nlow: " + low +"\nhigh: " + high + "\nmid: " +mid);

        return high;
    }
}