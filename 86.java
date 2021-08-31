 // 86. Partition List

class Solution {
    public ListNode partition(ListNode curr, int x) {
        ListNode firstList = new ListNode();
        ListNode less = firstList;

        ListNode secondList = new ListNode();
        ListNode greater = secondList;

        while (curr != null) {
            if (curr.val < x) {
                less.next = curr;
                less = less.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }

        // Connect two lists, good practice with a dummy head
        greater.next = null;
        less.next = secondList.next;

        return firstList.next;
    }
}
