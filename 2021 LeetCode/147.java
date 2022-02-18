class Solution {
    // Use dummy pointer, prev pointer, and curr pointer to do the insertion of each
    // node

    // Time: O(n^2)
    // Space: O(1)
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy;

            // Repeat until find the place to insert the current node to the front
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            // Remember the position of unsorted node
            ListNode next = curr.next;

            // Insert to the front
            curr.next = prev.next;

            // Next unsorted node
            prev.next = curr;

            curr = next;
        }

        return dummy.next;
    }
}