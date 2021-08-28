class Solution {
    // using division operation
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int exceptZero = 1;
        int zeros = 0;
        for (int n : nums) {
            product *= n;
            if (n != 0)
                exceptZero *= n;
            else
                zeros++;
        }

        if (zeros > 1)
            exceptZero = 0;

        for (int i = 0; i < nums.length; i++)
            nums[i] = nums[i] != 0 ? product / nums[i] : exceptZero;

        return nums;
    }
}