July 26, 2021

## Week 2 - Linked List

<br>

## Monday

### [24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Input: 1 -> 2 -> 3 -> 4  
Output: 2 -> 1 -> 4 -> 3

#### Approach:

- Dealing with two nodes at a time, keep track of a first and second pointer and also a prev pointer to link every pairs  
  <img src="img/LinkedList-2-24.jpeg" alt="approach 24" width="600" >

```java
// Time: O(n)
// Space: O(1)
public ListNode swapPairs(ListNode head) {
    ListNode res = new ListNode(0); // for returning the new head
    res.next = head;
    ListNode prev = res;

    while (head != null && head.next != null) {

        ListNode first = head;
        ListNode second = head.next;

        prev.next = second;
        first.next = second.next;
        second.next = first;

        prev = first;
        head = first.next;
    }
    return res.next;
}
```

<br>

### [61. Rotate List](https://leetcode.com/problems/rotate-list/)

Given the head of a linked list, rotate the list to the right by **k** places.

Input: 1 -> 2 -> 3 -> 4 -> 5, k = 2  
Output: 4 -> 5 -> 1 -> 2 -> 3

Input: 0 -> 1 -> 2, k = 4  
Output: 2 -> 0 -> 1

#### Approach:

- Based on the examples, it's uncessary to perform actual rotations to the list which would result in **k\*n** iterations.
- Thus, simply use n - number of nodes and k - number of iterations to calculate where to split the list and link two partitioned lists together.

  - Intuition:

  1. n == k or k%n == 0: no rotation needed, return original
  2. n < k: n - (k%n)
  3. n > k: n - k

  These three cases can be combined as `n-(k%n)`, but keep the first case to avoid unncessary iterations of the list.

  ```java
  // Time: O(n), exact = O(n + (k%n))
  // Space: O(1)
  public ListNode rotateRight(ListNode head, int k) {
      // If n <= 1, then NO Rotation needed
      if(head == null || head.next == null) return head;

      ListNode curr = head;
      int n = 1;

      // keep track of the tail node for later linking to the head
      while (curr.next != null) {
          n++;
          curr = curr.next;
      }

      // If k%n == 0, then NO Rotation needed
      if (k%n != 0) {
          n -= k%n; // gives the location of partition

          ListNode tail = curr;
          curr = head;

          // leaves one node before in order to do linking
          while (n > 1) {
              n--;
              curr = curr.next;
          }

          tail.next = head; // links the tail and head, now it creates a cycle
          head = curr.next; // mark the head of the new rotated list
          curr.next = null; // now, break the cycle by assigning the new tail node to point at null
      }
      return head;
  }
  ```

<br>

### [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

#### Approach:

- Use a new head, iterate two list and compare two nodes at a time. Have the new head link to the smallest node. Lastly, when either one list gets to the tail, the assumption is made that the non-empty list is the final part of a merged list, so we can link the rest by having the current node's next pointer pointing to the head of the non-empty list.

  ```java
  // Time: O(n)
  // Space: O(1)
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

<br>

### [160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)

Given the heads of two singly linked-lists `headA` and `headB`, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return `null`.

Input: a1 -> a2 -> c1 -> c2 -> c3  
 b1 -> b2 -> b3 -> c1 -> c2 -> c3  
Output: c1, intersection happens after c1

#### Approach 1:

- Use a hash table to store all nodes of one list and check each node of second list. If there is a intersection, it must already in the hash table.

  ```java
  // Time: O(n+m)
  // Space: O(n) stores all nodes from headA
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      Set<ListNode> visited = new HashSet<>();

      while (headA != null) {
          visited.add(headA);
          headA = headA.next;
      }

      if (visited.isEmpty()) return null;

      while (headB != null) {
          if (visited.contains(headB))
              return headB;
          headB = headB.next;
      }

      return null;
  }
  ```

#### Approach 2:

1. same length lists, either has intersection node or not such that list has `x` nodes. Then, listA has to skip `m-x` nodes and listB has to skip `n-x` nodes. Thus, `m-x = n-x when m=n` and only `n iteration` needed.
2. different length list, for two pointers to meet, more passes is needed when two same speed pointers meet.

```java
public ListNode getIntersectionNodeTwoPointer(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        // int i = 0;
        while (a != b) {
            // System.out.println((++i) + " " + (a == null ? "-" : a.val) + " " + (b == null ? "-" : b.val));
            a = a == null ? headA : a.next;
            b = b == null ? headB : b.next;
        }
        return a;
    }
```

<br>

### [189. Rotate Array](https://leetcode.com/problems/rotate-array/)

Given an array, rotate the array to the right by `k` steps, where `k` is non-negative.

Input: nums = [1,2,3,4,5,6,7], k = 3  
Output: [5,6,7,1,2,3,4]

#### Approach 1: (Extra Memory)

- Copy origin array to an extra array to memorize. Calculate the index of the rotated leftmost element and perform the parition by copying from the memorized array.

  ```java
  // Time: O(n) one pass iteration of overwriting the rotated array
  // Space: O(n) to store the original array
  public void rotate(int[] nums, int k) {
          int n = nums.length;

          if(k%n != 0)  {
              int [] ans = nums.clone();
              int x = n-(k%n) +1;

              for (int i = 0, j = x-1; i < n; i++, j++) {
                  if(j < n)
                      nums[i] = ans[j];
                  else
                      nums[i] = ans[j-n];
              }
          }
      }
  ```

<br>
<br>

## Tuesday
