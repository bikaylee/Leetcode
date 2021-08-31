// 25. Reverse Nodes in k-Group

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    
    // Reverse sublists in size of k
    //      Case 1. size of list % k == 0, all sublists of k need to be reversed
    //      Case 2. size of list & k != 0, connect the remaining end sublist
    
    // 'dummy' - Use dummy head to avoid empty linkedlist and convience in returning 
    // 'prev' - start with dummy head as 'prev' to connect sublists
    // 'curr' - iterate through the lists 
    // 'while (curr != null)'
    //      'start' = 'curr' node 
    //      'end' - find the "start + (k-1)" node - (position of start + (k-1) = k)
    //           **EDGE: if there is no k nodes remaining 
    //                      'prev.next' = 'start'
    //                      'return dummy.next'
    //      'curr' = 'end.next' - to mark the starting of next sublist of size k
    //      'end.next' = 'null' - to break this sublist to be independent for later reverse
    //      'newSublistHead' = 'reverse(start)' since end.next is null which is independent from original list
    //      'prev.next' = 'newSublistHead' - connect previous sublists to new sublist
    //      'prev' = 'start' - the last node of the reversed sublist
    // 'return dummy.next'     
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
        // use dummy to store all new returning list since sub-list in size k will be reversed
        ListNode dummy = new ListNode(0);
        
        // to connect between sublists and new sublist
        ListNode prev = dummy;          
        ListNode curr = head;          
        
        while (curr != null) {
            ListNode start = curr;      
            ListNode end = curr;        
            
            // move end pointer to kth node from start pointer
            int i = k;
            while (--i > 0 && end != null) 
                end = end.next;            
            
            // **EDGE: if there is no k nodes remaining 
            if (end == null) {          
                prev.next = start;
                break;
            }
            
            // to mark the starting of next sublist
            curr = end.next;                
            
            // to break this sublist to be independent for reverse use
            end.next = null;
            
            // connect previous sublists to new sublist
            prev.next = reverse(start);
            
            // the last node of the reversed sublist
            prev = start;
        }

        return dummy.next;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseKGroupStack(ListNode head, int k) {
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