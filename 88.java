// 88. Merge Sorted Array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = m + n - 1;
        int len = m + n;

        while (i >= 0) {
            nums1[j--] = nums1[i--];
        }

        i = n;
        j = 0;
        for (int k = 0; k < len; k++) {
            if (i >= len || j >= n) {
                nums1[k] = i >= len ? nums2[j++] : nums1[i++];
            } else {
                if (nums1[i] <= nums2[j]) {
                    nums1[k] = nums1[i];
                    i++;
                } else if (nums2[j] < nums1[i]) {
                    nums1[k] = nums2[j];
                    j++;
                }
            }
        }
    }
}