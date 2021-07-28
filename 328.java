// 328. Odd Even Linked List

public class 328 {
    /**
     * Separate into two list, one storing odds and another stores the evens. Keep an extra point to remember the head of the even list. 
     * Lastly, have the tail node of odd list to point to the head of even list.
     */

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
}
