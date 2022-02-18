// 82. Remove Duplicates from Sorted List II

class Solution {
    // Time: O(n)
    // Space: O(n)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        HashMap<Integer, Integer> count = new HashMap();
        while (curr != null) {
            count.put(curr.val, count.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }

        ListNode prev = dummy;
        curr = head;
        while (curr != null) {
            if (count.get(curr.val) == 1) {
                prev.next = curr;
                prev = prev.next;
            }
            curr = curr.next;
        }

        if (prev.next != null)
            prev.next = null;

        return dummy.next;
    }

    /**
     * Use sentinel head and predecessor to skip all duplicates
     */

    // Time: O(n)
    // Space: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        // sentinel
        ListNode sentinel = new ListNode(0, head);

        // predecessor = the last node
        // before the sublist of duplicates
        ListNode pred = sentinel;

        while (head != null) {
            // if it's a beginning of duplicates sublist skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // skip all duplicates
                pred.next = head.next;
                // otherwise, move predecessor
            } else {
                pred = pred.next;
            }
            // move forward
            head = head.next;
        }

        return sentinel.next;
    }
}
