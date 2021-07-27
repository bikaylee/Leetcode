//160. Intersection of Two Linked Lists

public class Solution {

    public ListNode getIntersectionNodeTwoPointer(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        // int i = 0;
        while (a != b) {
            // System.out.println((++i) + " " + (a == null ? "-" : a.val) + " " + (b == null
            // ? "-" : b.val));
            a = a == null ? headA : a.next;
            b = b == null ? headB : b.next;
        }
        return a;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setB = new HashSet<>();
        while (headB != null) {
            setB.add(headB);
            headB = headB.next;
        }
        while (headA != null) {
            if (setB.contains(headA))
                return headA;
            headA = headA.next;
        }
        return null;
    }
}