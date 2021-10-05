// 27. Remove Element

class Solution {

    // 10-05-2021
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length;

        while (i < j) {
            // Put every target element int the back
            // and swap it with the back element
            if (nums[i] == val) {
                nums[i] = nums[--j];
            } else {
                i++;
            }
        }

        return i;
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}