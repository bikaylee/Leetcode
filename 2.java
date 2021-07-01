// 2. Add Two Numbers
// similar to 415. Add Strings

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sum = new ListNode();
        ListNode curr = sum;

        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            int comp = n1 + n2 + carry;

            carry = comp / 10;
            curr.next = new ListNode(comp % 10);
            curr = curr.next;

            // System.out.println(curr.val);

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry > 0)
            curr.next = new ListNode(carry);

        return sum.next;
    }
}