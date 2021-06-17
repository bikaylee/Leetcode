// 1089. Duplicate Zeros

// Brute Force
class Solution {
    public void duplicateZeros(int[] arr) {

        boolean hasZero = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0 && !hasZero) {
                for (int j = arr.length - 1; j > i; j--) {
                    // System.out.println(arr[j-1]);
                    arr[j] = arr[j - 1];
                }
                arr[i + 1] = 0;
                hasZero = true;
            } else {
                hasZero = false;
            }
        }
    }
}