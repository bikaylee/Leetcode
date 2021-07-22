
// 231. Power of Two

class Solution {

    public boolean isPowerOfTwoMath(int n) {
        return (Math.log(n) / Math.log(2)) % 1 < 0.000000001;
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }
}