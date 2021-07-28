// 141. Linked List Cycle

public class 141 {
    /**
     *  Use Hash Set to store visited nodes, if one's link points to a visited node, then there is a cycle.
     */

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

    /**
     * Two pointers at different speed. Whether the track is straight or circular, two pointers will meet at some point.
     *  1. slow pointer at 1m/s
     *  2. fast pointer at 2m/s
     */
    // Time: O(n)
    //      1. O(n) = No cycle: the slow pointer will meet the fast pointer at end of the list
    //      2. O(N+K) which is O(n)= Has cycle: for the faster pointer to catch up with the slow pointer,
    //          it requires extra `K` cyclic length to meetup.
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
}
