/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */

//no need to use count variable --> just a pointer manipulation
var oddEvenList = function(head) {
    
    if(head === null) return null; //case when there's no node
    let oddPtr = head;
    let evenHead = head.next;
    let evenPtr = evenHead;
    while(evenPtr != null && evenPtr.next != null){ //checks if at least there are 3 or more nodes
        oddPtr.next = evenPtr.next;
        oddPtr = oddPtr.next;
        evenPtr.next = oddPtr.next;
        evenPtr = evenPtr.next;   
    }
    oddPtr.next = evenHead;
    return head;
};


