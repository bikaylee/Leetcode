
// 24. Swap Nodes in Pairs

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p1 = head;
        ListNode p2 = null;
        ListNode prev = dummy;

        while (p1 != null && p1.next != null) {
            p2 = p1.next;

            prev.next = p2;
            p1.next = p2.next;
            p2.next = p1;

            prev = p1;
            p1 = prev.next;
        }

        return dummy.next;
    }
}
