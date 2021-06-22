/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */


//two pointer approach: fast and slow
//fast will always move ahead of slow pointer
//edge case: 
//if the head.val == val (its a problem)
//we keep looping over the node until the node.val != val
//that will be done by the fast ptr, 
//once we find the node.val!= val, we set the head to that node and break the loop
//we then start another loop,(this loop would be a normal loop, if head.val != val case)
//where fast ptr will be wherever it stopped, (normally will start at the beginning node)
//that is when we bring in the slow pointer
//slow pointer = null, initially, 
//we only point Slow when the fast.val is not equal to the val, (that's how the slow will move)
//condition to check will be: (when fast.val != val)
//if the slow pointer.next is not equal to fast, 
//then make sure to point the fast pointer, move slow = fast
//if the slow pointer.next is equal then just move the slow pointer where the fast is 
//at the end, to check if the slow is null, then we know, we kept removing the node, 
//and never found the node.val != val

var removeElements = function (head, val) {
    if (head == null) return null;

    let fast = head;
    let slow = null;

    if (head.val == val) {
        while (fast) {
            if (fast.val != val) {
                head = fast;
                break;
            }
            fast = fast.next;
        }
    }

    //if we hit the loop below, we know for sure the initial node.val != val 
    while (fast) {

        if (fast.val != val) {

            //need to check slow != null, sometimes, we might end up with the case 
            //initially slow = null, and when since this if condition is the first check
            //when slow = null --> slow.next (if null) will throw an error
            if (slow && slow.next != fast) {
                slow.next = fast;
            }
            slow = fast;
        }
        fast = fast.next;
    }

    //if the slow is still pointing at the null, then we know, there never was any 
    //node that was node.val != val
    if (!slow) return null;

    //meaning we found node that had to be removed 
    //but werent able to move the slow to where the fast was
    //then, we just close the slow.next and end it
    //we also know that slow != null, since if it was to be null it would be returned above
    if (fast == null && slow.next != null) slow.next = null;


    return head;
};


