// 83. Remove Duplicates from Sorted List

class Solution {
    /**
     * - Iterate through and unlink the duplicated nodes from the list.
     * 
     * @param head
     * @return
     */
    // Time: O(n)
    // Space: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return head;
    }
}
