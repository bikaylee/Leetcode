class Solution {
    // Binary Representation
    public int getDecimalValue(ListNode head) {

        int ans = 0;
        while (head != null) {
            ans = 2 * ans + head.val;
            head = head.next;
        }

        return ans;
    }

    // Bit Manipulation
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) | head.next.val;
            head = head.next;
        }
        return num;
    }

    // Reverse
    public int getDecimalValue(ListNode head) {
        head = reverse(head);

        int i = 0;
        int ans = 0;
        while (head != null) {
            ans += head.val == 0 ? 0 : (int) Math.pow(2, i);
            head = head.next;
            i++;
        }

        return ans;
    }

    private ListNode reverse(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}