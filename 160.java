//160. Intersection of Two Linked Lists

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setB = new HashSet<>();
        while(headB != null)
        {
            setB.add(headB);
            headB = headB.next;
        }
        while(headA != null)
        {
            if(setB.contains(headA))
                return headA;
            headA = headA.next;
        }
        return null;
    }
}