// 414. Third Maximum Number

class Solution {
    public int thirdMax(int[] nums) {

        int n = nums.length;
        if (n <= 1)
            return nums[0];

        Arrays.sort(nums);

        int count = 2;
        int max = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] != nums[i]) {
                count--;
            }
            if (count == 0) {
                max = nums[i];
                break;
            }
        }
        return max;
    }
}