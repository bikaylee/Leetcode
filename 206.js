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
//will use two pointer approach: (with additional pointer--> backup pointer)
//fast pointer -> will travel one step ahead of slow pointer
//slow pointer.next -> will point to the backup pointer
//then backup pointer will be just a backup pointer so that slow pointer can keep connecting the node backward
//fast pointer will be like a way for slow pointer to jump into next node after disconnecting the node it was in
//at the end the backup pointer will be the head pointer. so could just return backup pointer
//edge case: 
//if no node -> return null
//if one node -> return that node
var reverseList = function (head) {
    if (!head) return null;
    if (!head.next) return head;
    let backupPtr = null; //essential as the first node needs to point to null
    let fastPtr = head;
    let slowPtr = head;
    while (slowPtr) {
        fastPtr = fastPtr.next;
        slowPtr.next = backupPtr;
        backupPtr = slowPtr;
        slowPtr = fastPtr;
    }
    return backupPtr;
};