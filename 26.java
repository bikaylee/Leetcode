// 26. Remove Duplicates from Sorted Array

class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if (n <= 1)
            return n;

        int i = 0, j = 1;
        int count = 0;

        while (i < n) {
            while (j < n && nums[i] == nums[j])
                j++;
            i++;
            if (j >= i && j < n) {
                nums[i] = nums[j];
                count = i;
            }
        }

        return count + 1;
    }
}