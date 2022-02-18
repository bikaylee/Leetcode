// 283. Move Zeroes

class Solution {
    // * nums = [0, 1, 0, 3, 12], (z = 0, i = 0) -> first occurence of zero is found
    // * [1, 0, 0, 3, 12], (z = 1, i = 1) -> i = 1 and swap with first zeroPos and
    // increment zeroPos
    // * [1, 0, 0, 3, 12], (z = 1, i = 2) -> no swap, increment i
    // * [1, 3, 0, 0, 12], (z = 2, i = 3) -> swap zeroPos with i, increment both
    // * [1, 3, 12, 0, 0], (z = 3, i = 4) -> swap zeroPos with i, increment both
    // (either z or i reaches n, break)
    // *
    // * nums = [1, 2, 0, 0, 3] (z = -1, i = 0)
    // * [1, 2, 0, 0, 3] (z = -1, i = 1)
    // * [1, 2, 0, 0, 3] (z = 2, i = 2)
    // * [1, 2, 0, 0, 3] (z = 2, i = 3)
    // * [1, 2, 3, 0, 0] (z = 3, i = 4)

    public void moveZeroes(int[] nums) {
        int zeroPos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && zeroPos < 0)
                continue;
            else if (nums[i] == 0 && zeroPos < 0)
                zeroPos = i;
            else if (nums[i] != 0 && zeroPos >= 0) {
                nums[zeroPos] = nums[i];
                nums[i] = 0;
                if (zeroPos + 1 <= i)
                    zeroPos++;
                else
                    zeroPos = -1;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                int temp = nums[cur];
                nums[cur] = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt++] = temp;
            }
        }
    }
}