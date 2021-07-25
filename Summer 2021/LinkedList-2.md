## Week 2 - Linked List

<br>

### [24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)

### [](https://leetcode.com/problems/rotate-list/)

### [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode();
    ListNode curr = head;

    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            curr.next = l1;
            l1 = l1.next;
        } else {
            curr.next = l2;
            l2 = l2.next;
        }
        curr = curr.next;
    }

    curr.next = l1 != null ? l1:l2;

    return head.next;
}
```
