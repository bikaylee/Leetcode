// 287. Find Duplicate Number

/**
 * Both cases don't meet the requirements
 * 
 * Requirement: O(n) Time and O(1) Space
 */
class Solution {
    // Time: O(n log n), sorting
    // Space: O(logn) or O(n) depends on the sorting algorithm
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return nums[i];
        }
        return -1;
    }

    // Time: O(n)
    // Space: O(n)
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }
}
