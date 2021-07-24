July 22, 2021

## Week 1 - Warm Up - Linked List

<br>

### [237. Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/)

Given that the node to be deleted is guaranteed not the **tail** node. Instead of given access to the head of the list, the node to be deleted is given directly.

Input: 4 -> 5 -> 1 -> 9 <br>
Output: 4 -> 1 -> 9

#### Approach 1:

- Iterate the remaining list and replace its value with the next and let the node before the original tail node and have it points to null.

  ```java
  // Time: O(n), n is the number of nodes from given til the end of the list
  // Space: O(1)
  public void deleteNode(ListNode node) {
  ListNode tail = node;

  while(node.next != null) {
      int nextVal = node.next.val;
      node.val = nextVal;
      tail = node;
      node = node.next;
  }

  tail.next = null;
  }
  ```

#### Approach 2:

- Since we don't have access to the head of the list, we can replace the current node value with the value of the next node and remove that node from the list.

  ```java
  // Time: O(1)
  // Space: O(1)
  public void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;
  }
  ```

### [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)

Given the **head** of a singly linked list, reverse the list, and return the reversed list.

Input: 1 -> 2 -> 3 -> 4 <br>
Output: 4 -> 3 -> 2 -> 1

#### Approach:

- Flip all links of each node to the opposite side.

  ```java
  // Time: O(n)
  // Space: O(1)
  public ListNode reverseList(ListNode head) {

      ListNode curr = head;
      ListNode next = null;

      while (curr != null) {
          ListNode temp = curr.next; // remember teh next node
          curr.next = next;   // assign link to the next
          next = curr;
          curr = temp;
      }

      return next;
  }
  ```

### [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

Given head, the head of a linked list, determine if the linked list has a cycle in it.

Input: head = \[3,2,0,-4], -4 points to 2 <br>
Output: true <br>
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

#### Approach 1: (Hash Table)

- Use Hash Set to store visited nodes, if one's link points to a visited node, then there is a cycle.

  ```java
  // Time: O(n)
  //  Space: O(n), hash table for storing visited nodes
  public boolean hasCycle(ListNode head) {
      Set<ListNode> visited = new HashSet<ListNode>();

      while (head != null) {
          visited.add(head);
          if (visited.contains(head.next)) {
              return true;
          }
          head = head.next;
      }

      return false;
  }
  ```

#### Approach 2: (Floyd's Cycle Finding Algorithm)

- Two pointers at different speed. Whether the track is straight or circular, two pointers will meet at some point.

  1. slow pointer at 1m/s
  2. fast pointer at 2m/s

  ```java
  // Time: O(n)
  //      1. O(n) = No cycle: the slow pointer will meet the fast pointer at end of the list
  //      2. O(N+K) which is O(n)= Has cycle: for the faster pointer to catch up with the slow pointer,
  //          it requires extra **K** cyclic length to meetup.
  // Space: O(1)
  public boolean hasCycle(ListNode head) {
      if (head == null) {
          return false;
      }

      ListNode slow = head;
      ListNode fast = head.next;
      while (slow != fast) {
          if (fast == null || fast.next == null) {
              return false;
          }
          slow = slow.next;
          fast = fast.next.next;
      }
      return true;
  }
  ```

### [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

Given two **non-empty** linked lists representing two **non-negative** integers. Digits are in **reversed order.** Do not contain any leading zero, except number 0 itself.

Input: 2 -> 4 -> 3 (342), 5 -> 6 -> 4 (465) <br>
Output: 7 -> 0 -> 8 (807)

##### Approach: (Elementary Math)

- Since the order is reversed, start from the single digit with a carry all the way to the rightmost node.

  ```java
  // Time: O(n)
  // Space: O(n)
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

      ListNode sum = new ListNode();
      ListNode curr = sum;

      int carry = 0;

      while (l1 != null || l2 != null) {
          int n = (l1 != null ? l1.val:0) + (l2 != null ? l2.val:0) + carry;

          curr.next = new ListNode(n%10);
          curr = curr.next;
          carry = n/10;

          l1 = l1 == null? null:l1.next;
          l2 = l2 == null? null:l2.next;
      }

      if(carry > 0)
          curr.next = new ListNode(carry);


      return sum.next;
  }
  ```

### [328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)

First node is considered **odd** and second node is **even**.

Input: 1 -> 2 -> 3 -> 4 -> 5 <br>
Output: 1 -> 3 -> 5 -> 2 -> 4

#### Approach:

- Separate into two list, one storing odds and another stores the evens. Keep an extra point to remember the head of the even list. Lastly, have the tail node of odd list to point to the head of even list.

  ```java
  // Time: O(n)
  // Space: O(1)
  public ListNode oddEvenList(ListNode head) {
  if(head == null) return head;

  ListNode oddPointer = head;
  ListNode evenPointer = head.next;

  ListNode even = head.next;

  while(evenPointer != null && evenPointer.next != null) {
      oddPointer.next = evenPointer.next;
      oddPointer = oddPointer.next;
      evenPointer.next = oddPointer.next;
      evenPointer = evenPointer.next;
  }

  oddPointer.next = even;

  return head;
  }
  ```
