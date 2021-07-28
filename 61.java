// 61. Rotate List

class Solution {
    /**
     * Based on the examples, it's uncessary to perform actual rotations to the list
     * which would result in `k*n` iterations. - Thus, simply use n - number of
     * nodes and k - number of iterations to calculate where to split the list and
     * link two partitioned lists together.
     * 
     * Intuition:
     * 
     * 1. `n == k` or `k%n == 0`: no rotation needed, return original
     * 
     * 2. `n < k`: `n - (k%n)`
     * 
     * 3. `n > k`: `n - k`
     * 
     * These three cases can be combined as `n-(k%n)`, but keep the first case to
     * avoid unncessary iterations of the list.
     */

    // Time: O(n), exact = O(n + (k%n))
    // Space: O(1)
    public ListNode rotateRight(ListNode head, int k) {
        // If n <= 1, then NO Rotation needed
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        int n = 1;

        // keep track of the tail node for later linking to the head
        while (curr.next != null) {
            n++;
            curr = curr.next;
        }

        // If k%n == 0, then NO Rotation needed
        if (k % n != 0) {
            n -= k % n; // gives the location of partition

            ListNode tail = curr;
            curr = head;

            // leaves one node before in order to do linking
            while (n > 1) {
                n--;
                curr = curr.next;
            }

            tail.next = head; // links the tail and head, now it creates a cycle
            head = curr.next; // mark the head of the new rotated list
            curr.next = null; // now, break the cycle by assigning the new tail node to point at null
        }
        return head;
    }
}
