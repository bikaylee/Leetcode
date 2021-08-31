// 92. Reverse Linked List II           
class Solution {
    
    // Have a dummy to easily track the previous, since the whole list might be reversed
    // Use two pointers to find the left node and right node, then perform reverse
    // break the right node with 'right.next = null' to practice reverse
    // Keep track of the previous and next of the sublist(left, right) 
    // to connect the reversed sublist back to the original list
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) 
            prev = prev.next;
        
        ListNode start = prev.next;
        ListNode end = start;
        
        while (right-- > left) 
            end = end.next;
        
        ListNode next = end.next;
        end.next = null;
        prev.next = reverse(start);
        start.next = next;
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}