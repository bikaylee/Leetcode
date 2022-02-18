// 23. Merge k Sorted Lists
class Solution {
    // Time: O(n log k) where each node will be sorted with O(log k)
    // Space: O(n)

    /**
     * Use a priority queue to store all nodes by its values, and use new head
     * pointer to link all nodes in the priority queue.
     * 
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // if (lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);

        for (ListNode list : lists) {
            while (list != null) {
                // System.out.println(list.val + " " + (list.next == null ?
                // "null":list.next.val));
                pq.add(list);
                list = list.next;
            }
        }

        ListNode sorted = new ListNode(0);
        ListNode curr = sorted;
        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
        }

        curr.next = null;
        return sorted.next;
    }
}
