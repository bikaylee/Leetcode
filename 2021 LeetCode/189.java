// 189. Rotate Array

class Solution {
    /**
     * Reverse the whole array first, parition the reversed array by `k` and
     * reversed each subarray.
     * 
     * @param nums
     * @param k
     */

    // Time: O(n), one pass to reverse entire array and another pass to reverse two
    // subarrays.
    // Space: O(1), in place
    public void rotateInPlace(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k != 0) {
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;

            start++;
            end--;
        }
    }

    /**
     * Copy original array to an extra array to memorize. Calculate the index of the
     * rotated leftmost element and perform the parition by copying from the
     * memorized array.
     * 
     * @param nums
     * @param k
     */
    // Time: O(n) one pass iteration of overwriting the rotated array
    // Space: O(n) to store the original array
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k % n != 0) {
            int[] ans = nums.clone();
            for (int i = 0, j = n - (k % n); i < n; i++, j++)
                nums[i] = ans[j < n ? j : j - n];
        }
    }
}
