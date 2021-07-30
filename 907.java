// 907. Sum of Subarray Minimums

/**
 * Given an array of integers arr, find the sum of min(b), where b ranges over
 * every (contiguous) subarray of arr. Since the answer may be large, return the
 * answer modulo 10^9 + 7.
 * 
 * Input: arr = `[3,1,2,4]`
 * 
 * Output: `17`
 * 
 * Explanation: Subarrays are `[3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2],
 * [1,2,4], [3,1,2,4].` Minimums are `3, 1, 2, 4, 1, 1, 2, 1, 1, 1.`
 */

class Solution {
    /**
     * Look over videos for explanation
     * 
     * In every subset of integer, expand to left and right until no more elements
     * are greater than itself or reaches the boudary. Then, every subset's minimum
     * should be the product of including itself to the left and the right will
     * output the current sum of this subset and every subsets within the current
     * subset.
     * 
     * @param arr
     * @return int
     */
    public int sumSubarrayMins(int[] arr) {
        final int kMod = 1000000007;
        final int n = arr.length;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            int left = 0;
            for (int j = i - 1; j >= 0 && arr[j] > arr[i]; --j, ++left)
                ;

            int right = 0;
            for (int j = i + 1; j < n && arr[j] >= arr[i]; ++j, ++right)
                ;

            ans = (int) ((ans + (long) arr[i] * (left + 1) * (right + 1)) % kMod);
            // System.out.println("left: " + left + "\nright: " + right + "\nans: " + ans +
            // "\n");
        }

        return ans;
    }
}