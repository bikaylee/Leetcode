// 25. Reverse Nodes in k-Group

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        Deque<ListNode> group = new ArrayDeque<>();

        ListNode prev = dummy;
        ListNode mark = null;
        while (head != null) {
            mark = head;
            for (int i = 0; i < k; i++) {
                if (head == null) {
                    prev.next = mark;
                    return dummy.next;
                }
                group.push(head);
                head = head.next;
            }
            while (!group.isEmpty()) {
                prev.next = group.pop();
                prev = prev.next;
            }
        }

        if (mark == prev)
            prev.next = null;

        return dummy.next;
    }
}