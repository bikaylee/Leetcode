// 239. Sliding Window Maximum

class Solution {

    public int[] maxSlidingWindow3(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();

        int[] ans = new int[nums.length - k + 1];
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j >= k) {
                ans[i] = nums[dq.peekFirst()];
                if (dq.peekFirst() == i)
                    dq.removeFirst();
                i++;
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[j])
                dq.removeLast();
            dq.addLast(j);
        }

        ans[i] = nums[dq.peekFirst()];
        return ans;
    }

    // Monotonic Deque - decreasing order, first is always the greatest
    
    // To main a monotonic deque
    //  if the new element is greater the current max in deque:
    //          add to the first and became the new max
    //  else:
    //          the new element should go to the right side
    //          remove all right elements until the rightmost element >= new element
    
    
    // when sliding the window
    //      if the max was just been shifted:
    //          remove that element until the first element in deque is within the current window
    
    private Deque<Integer> dq = new ArrayDeque<>();

    private void helper(int[] nums, int i) {
        if (!dq.isEmpty() && nums[dq.peekFirst()] < nums[i])
            dq.addFirst(i);
        else {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            dq.addLast(i);
        }
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        for (int i = 0; i < k; i++)
            helper(nums, i);

        int[] ans = new int[nums.length - k + 1];
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {

            while (!dq.isEmpty() && dq.peekFirst() < i)
                dq.pollFirst();

            helper(nums, j);
            ans[i] = nums[dq.peekFirst()];
        }
        return ans;
    }

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