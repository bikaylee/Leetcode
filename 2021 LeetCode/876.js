
//we know that when we have two pointers
//slow and fast
//fast moving 2X
//slow moving 1X
//by the time fast reaches the end or the null, 
//slow will be pointing at the middle node
var middleNode = function(head) {
    //we already know that the head is NOT going to be null
    if(head.next === null) return head;
    let slow = head;
    let fast = head;
    
    //gotta run the loop till fast ptr reaches the end
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    
    return slow;
};
