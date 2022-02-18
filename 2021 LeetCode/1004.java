// 1004. Max Consecutive Ones III

class Solution {

  // 9/12/2021
  // Move right pointer and keep track of
  // how many zeros in current window
  // so we know how many has to be flipped

  // if number need to flipped > k
  // move the left pointer until == k flipped
  public int longestOnes(int[] nums, int k) {
    int left = 0, right = 0;

    int ans = 0;
    int ones = 0;
    while (right < nums.length) {
      if (nums[right] == 1)
        ones++;
      while (right - left + 1 - ones > k) {
        if (nums[left] == 1)
          ones--;
        left++;
      }
      ans = Math.max(right - left + 1, ans);
      right++;
    }

    return ans;
  }

  public int longestOnes(int[] A, int K) {
    int left = 0, right;
    for (right = 0; right < A.length; right++) {
      // If we included a zero in the window we reduce the value of K.
      // Since K is the maximum zeros allowed in a window.
      if (A[right] == 0)
        K--;
      // A negative K denotes we have consumed all allowed flips and window has
      // more than allowed zeros, thus increment left pointer by 1 to keep the window
      // size same.
      if (K < 0) {
        // If the left element to be thrown out is zero we increase K.
        if (A[left] == 0)
          K++;
        left++;
      }
    }
    return right - left;
  }
}