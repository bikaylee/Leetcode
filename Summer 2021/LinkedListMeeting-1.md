July 24, 2021

## Week 1 - Meeting - Linked List

### Mock Interview

1. [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
2. [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
3. [328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)

### Pair Programming

### [146. LRU Cache](https://leetcode.com/problems/lru-cache/)

- Did not solve this problem. Origianl thought was use singly linked list queue and a hashmap to store the key-value pair.
- Solution: use doubly linked list and store the key with corresponding node into a hashmap. When update the most recent key-value pair, we can get it from the hashmap and use its prev and next pointer to remove itself from the linked list. Lastly, append the new key-value pair to the end.

### [234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)

- Reverse Second Half In-place

  ```java
  // Time: O(n)
  // Space: O(1)
  public boolean isPalindrome(ListNode head) {
      if (head == null) return false;

      ListNode slow = head;
      ListNode fast = head;

      while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
      }

      ListNode reversedHalf = null;
      ListNode curr = slow;

      while (curr != null) {
          ListNode temp = curr.next;
          curr.next = reversedHalf;
          reversedHalf = curr;
          curr = temp;
      }

      while (reversedHalf != null && head != slow) {
          // System.out.println(reversedHalf.val);
          // System.out.println(head.val);

          if(head.val != reversedHalf.val) return false;

          reversedHalf = reversedHalf.next;
          head = head.next;
      }

      return true;
  }
  ```
