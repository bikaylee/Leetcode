/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */

//even and odd concepts
//when even --> 1 2 3 4 --> we check all the values.
//when odd --> 1 2 3 4 5 --> we know that we dont have to check for the mid, so we skip checking for 3

//finding the mid
//when it comes to finding the mid of the linked list --> twp ptr approach
//fast will move 2X speed and slow will move 1X speed
// odd elements --> fast ptr is not null
// even elements --> fast ptr is null


//approach 

//first find the half of the list using 2 ptr approach
//then see if the linked list is even or odd (even --> fast is null) (odd --> fast is NOT null)
//then fast = head, start to reverse from slow
//remember if ODD -> move the slow ptr one step forward to make sure we dont care about the odd num
// var isPalindrome = function(head) {
//     if(head === null)return null; //check for null node

//     //first subproblem finding the mid of the linked list
//     let slow = head;
//     let fast = head;
//     while(fast != null && fast.next != null){
//         slow = slow.next;
//         fast = fast.next.next;
//     }

//     //second subproblem determining to check for even length or odd length
//     //if odd move the slow ptr one step forward
//     //if even we will not worry about moving the slow ptr
//     if(fast != null){
//         slow = slow.next;
//     }else{
//         slow = slow;
//     }

//     //third subproblem to reverse the linked list
//     let prevPtr = null;
//     let currPtr = slow;
//     let nextPtr = slow;

//     while(currPtr != null){
//         nextPtr = nextPtr.next;
//         currPtr.next = prevPtr;
//         prevPtr = currPtr;
//         currPtr = nextPtr;
//     }
//     slow = prevPtr;


//     //to check for each element if its palindrome, the reversed and not reversed list
//     //move back the fast to head
//     fast = head;
//     while(slow != null){
//         if(slow.val != fast.val) return false;
//         slow = slow.next;
//         fast = fast.next;
//     }

//     return true;
// };



//approach use helper function to find the reverse;
//again go uptil the mid of the node and pass on the half list to the helper function

var isPalindrome = function (head) {
    if (head === null) return null;

    //finding the mid of the list;
    let slow = head;
    let fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    //reverse the list
    slow = reverse(slow);

    //check for the palindrome case
    fast = head;
    //want to make sure u only loop till the node that slow is pointing
    //as fast still has access to the whole other nodes 
    while (slow != null) {
        if (slow.val != fast.val) return false;
        slow = slow.next;
        fast = fast.next;
    }
    return true;

}

//helper function to reverse
function reverse(llists) {
    let prev = null;
    let curr = llists;
    let fast = llists;
    while (curr != null) {
        fast = fast.next;
        curr.next = prev;
        prev = curr;
        curr = fast;
    }
    return prev;
}
