// 303. Range Sum Query - Immutable

class NumArray {

    private int[] dp;
    private int n;

    public NumArray(int[] nums) {
        this.dp = new int[nums.length + 1];
        int i = 1;
        for (int num : nums) {
            this.dp[i] = this.dp[i - 1] + num;
            i++;
        }

    }

    public int sumRange(int left, int right) {
        return this.dp[right + 1] - this.dp[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(left,right);
 */