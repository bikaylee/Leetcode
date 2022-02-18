// 143. Reorder List

class Solution {

    /**
     * - Use an arraylist to store all nodes with one pass. Then, use two pointers
     * to reorder the list from the arraylist. Lastly, the middle node will be
     * reordered as the tail node, its next is null.
     * 
     * @param head
     */

    // Time: O(n)
    // Space: O(n)
    public void reorderListArray(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        int n = list.size();
        for (int i = 0, j = n - 1; i + 1 < j; i++, j--) {
            list.get(i).next = list.get(j);
            list.get(j).next = list.get(i + 1);
        }

        list.get(n / 2).next = null;
    }

    /**
     * Use slow and faster point to locate the middle and reverse the second half of
     * the list.Place each node from two list accordingly.
     * 
     * @param head
     */
    // Time: O(n)
    // Space: O(1)
    public void reorderList(ListNode head) {
        ListNode p2 = head, p1 = head;

        while (p1 != null && p1.next != null) {
            p2 = p2.next; // slow pointer
            p1 = p1.next.next; // fast pointer
        }

        p2 = reverse(p2); // reverse the second half
        p1 = head; // first half

        while (p2.next != null) { // the middle node will be assign to second list's null pointer
            ListNode next = p1.next;
            p1.next = p2;
            p1 = next;

            next = p2.next;
            p2.next = p1;
            p2 = next;
        }
    }

    private ListNode reverse(ListNode curr) {
        ListNode next = null;
        while (curr != null) {
            ListNode prev = curr.next;
            curr.next = next;
            next = curr;
            curr = prev;
        }
        return next;
    }
}
