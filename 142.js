//floyds algo

var detectCycle = function(head) {
    
    //edge case-> where the head is null or head.next is null
    if(head === null || head.next === null) return null;
    
    let slow = head;
    let fast = head;
    
    //to check for the cycle
    //fast moves 2x speed
    //slow moves 1x speed
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast === slow) break;
    }
    if(fast === null || fast.next === null) return null
    
    //after we find the cycle, we reset one pointer to start from the beginning
    //the other to start from where both the pointers met
    //both pointer will have 1x speed. 
    //they will meet at the start of the cycle
    slow = head;
    while(slow != fast){
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
};
