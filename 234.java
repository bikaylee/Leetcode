//234. Palindrome Linked List


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while(curr != null)
        {
            length++;
            curr = curr.next;
        }
        
        
        if(length == 1)
            return true;
                
        Stack<Integer> stack = new Stack<>();
        curr = head;
        boolean odd = length%2 == 1;
        int n = length / 2;
        
        while(curr != null)
        {
            if(n > 0)
                stack.add(curr.val);
            else
            {
                // System.out.println(stack.toString());
                if(n == 0 && odd)
                    curr = curr.next;
                if(stack.pop() != curr.val)
                    return false;
            }
            n--;
            curr = curr.next;
        }            
    
        return true;
    }
}