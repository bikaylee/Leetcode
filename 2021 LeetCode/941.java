// 941. Valid Mountain Array

class Solution {
    public boolean validMountainArray(int[] arr) {
        int validInt = 0;
        int size = arr.length;
        int i = 1;

        // Walk up
        while (i < size && arr[i - 1] < arr[i++])
            validInt++;

        // cannot be the neither first nor last
        // since there should exist a peak after walking up
        if (validInt == 0 || validInt == size - 1)
            return false;

        // walk down
        i = size - 1;
        while (i > 0 && arr[i] < arr[i - 1]) {
            i--;
            validInt++;
        }

        return validInt == size - 1;
    }
}
