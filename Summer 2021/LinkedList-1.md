July 22, 2021

## Week 1 - Warm Up - Linked List

<br><br>

### 237. Delete Node in a Linked List

Given that the node to be deleted is guaranteed not the tail node. Instead of given access to the head of the list, the node to be deleted is given directly.

Input: 4 -> 5 -> 1 -> 9 <br>
Output: 4 -> 1 -> 9

#### Approach 1:

Time: O(n), n is the number of nodes from given til the end of the list <br>
Space: O(1)

- Iterate the remaining list and replace its value with the next and let the node before the original to point to null

```java
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

Time: O(1) <br>
Space: O(1)

- Since we don't have access to the head of the list, we can replace the current node value with the value of the next node and remove that node from the list.

```java
public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}
```
