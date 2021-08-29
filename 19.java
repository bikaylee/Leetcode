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
    // hashMap
    public ListNode removeNthFromEndHashMap(ListNode head, int n) {
        int size = 1;

        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode curr = head;

        while (curr != null) {
            map.put(size++, curr);
            curr = curr.next;
        }
        size--;

        if (n == size)
            return head.next;
        else if (n == 1)
            map.get(size - 1).next = null;
        else {
            map.get(size - n).next = map.get(size - n + 2);
        }

        return head;
    }

    // Two reverses
    public ListNode removeNthFromEndReverse(ListNode head, int n) {
        ListNode reverseHead = reverse(head);
        ListNode curr = reverseHead;
        if (n == 1)
            return reverse(reverseHead.next);
        while (--n > 1)
            curr = curr.next;
        if (curr.next != null)
            curr.next = curr.next.next;
        return reverse(reverseHead);
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

    // Two pass
    public ListNode removeNthFromEndTwo(ListNode head, int n) {
        int size = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            size++;
        }

        if (size == n)
            return head.next;

        size -= n;
        ListNode prev = head;
        while (--size > 0)
            prev = prev.next;

        if (prev.next != null)
            prev.next = prev.next.next;

        return head;
    }

    // One pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i <= n; i++)
            second = second.next;

        while (second != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }
}