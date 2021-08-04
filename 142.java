// 142. Linked List Cycle II

class Solution {
    // Time: O(n)
    // Space: O(n)
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head))
                return head;
            visited.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * - Use tortoise (slow) and hare (fast), if there is a cycle, two pointers will
     * eventually meet within the cycle. Then, based on the fact that the linked
     * list has a cycle. Set up the intersection pointer and the head pointer at the
     * same speed until both meets, which means that it happens to be the visited
     * node like in the hashtable. - Check mathematical proof: [Solution
     * Article](https://leetcode.com/problems/linked-list-cycle-ii/solution/)
     * 
     * @param head
     * @return
     */

    /**
     * Time: O(n) For cyclic lists, hare and tortoise will point to the same node
     * after F+C-hF+C−h iterations, as demonstrated in the proof of correctness.
     * F+C-h \leq F+C = nF+C−h≤F+C=n, so phase 1 runs in O(n)O(n) time. Phase 2 runs
     * for F < nF<n iterations, so it also runs in O(n) time. For acyclic lists,
     * hare will reach the end of the list in roughly \dfrac{n}{2} iterations,
     * causing the function to return before phase 2. Therefore, regardless of which
     * category of list the algorithm receives, it runs in time linearly
     * proportional to the number of nodes.
     *
     * Space: O(1) Floyd's Tortoise and Hare algorithm allocates only pointers, so
     * it runs with constant overall memory usage.
     */
    private ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }

        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        // If there is a cycle, the fast/slow pointers will intersect at some
        // node. Otherwise, there is no cycle, so we cannot find an entrance to
        // a cycle.
        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        // To find the entrance to the cycle, we have two pointers traverse at
        // the same speed -- one from the front of the list, and the other from
        // the point of intersection.
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }
}
