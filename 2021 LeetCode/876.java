class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }
}
