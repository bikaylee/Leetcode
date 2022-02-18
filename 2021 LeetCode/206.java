/** 
 * 206. Reverse Linked List
 * Week 1: Linked List - Problem 2 Warm Up
 * Let next node's next pointer points to the current node
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode reverseListSolution(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;

        ListNode curr = head;
        ListNode next = head.next;
        head.next = null;

        while (next != null) {
            ListNode temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }

        return curr;
    }

    public ListNode reverseList1(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}