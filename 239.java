// 239. Sliding Window Maximum

class Solution {
    /**
     * Use monotonic deque to store k range window in ascending order For every k
     * window, remove the first in deque if it's the last of previous window. Deque
     * size is always <= k.
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque();

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.removeLast();
            dq.addLast(i);
        }

        int[] ans = new int[nums.length - k + 1];
        int start = 0;
        for (int i = k; i < nums.length; i++, start++) {
            ans[start] = nums[dq.peekFirst()];
            if (dq.peekFirst() == start)
                dq.removeFirst();

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.removeLast();
            dq.addLast(i);
        }

        if (!dq.isEmpty())
            ans[start] = nums[dq.removeFirst()];

        return ans;
    }
}