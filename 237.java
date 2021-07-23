// 237. Delete Node in a Linked List

/**
 * Week 1: Linked List - Problem 1 Warm Up
 * 
 * Given node is the one to be deleted
 */

class Solution {

    // Iterate to overwrite each node's val
    public void deleteNodeIterate(ListNode node) {
        ListNode tail = node;
        while (node.next != null) {
            int nextVal = node.next.val;
            node.val = nextVal;
            tail = node;
            node = node.next;
        }
        tail.next = null;
    }

    // Replace the deleting node to its next node and remove the next node in the
    // list
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */