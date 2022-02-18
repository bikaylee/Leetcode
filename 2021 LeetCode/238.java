class Solution {

    // Left and Right (Prefix product and suffix product)
    public int[] productExceptSelfPrefix(int[] nums) {
        int n = nums.length;
        int[] left = nums.clone();
        int[] right = nums.clone();

        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
            left[i] = left[i - 1] * nums[i];
            right[j] = right[j + 1] * nums[j];
        }

        nums[0] = right[1];
        nums[n - 1] = left[n - 2];
        for (int i = 1; i < n - 1; i++) {
            nums[i] = left[i - 1] * right[i + 1];
        }

        return nums;
    }

    // using division operation (NOT ALLOWED)
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

    // TLE
    public int[] productExceptSelfBruteForce(int[] nums) {

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = 1;
            int count = 0;
            int zero = -1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i)
                    ans[i] *= nums[j];
                if (nums[j] == 0) {
                    count++;
                    zero = j;
                }
            }
            if (count > 1 && zero == i)
                ans[i] = 0;
        }

        return ans;
    }
}