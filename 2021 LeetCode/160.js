//approach would be to just set pointers in respective linked list
//if one pointer comes to an node end, just set that pointer to the head of the other linked list
//continue that in a while loop until the node from both linked list are not equal.
var getIntersectionNode = function(headA, headB) {
    //check if any linked list is null, if they are then just return null;
    if(headA === null || headB === null) return null;
    
    let aPtr = headA;
    let bPtr = headB;
    
    while(aPtr != bPtr){
        //check if the aPtr is null, if null, reset the aPtr to point to bPtr;
        //else keep moving
        if(aPtr === null) aPtr = headB;
        else aPtr = aPtr.next;
        
        //check if the bPtr is null, if null, reset the aPtr to point to bPtr;
        //else keep moving
        if(bPtr === null) bPtr = headA;
        else bPtr = bPtr.next;
    }
    //returning a node that contains the start of the intersection 
    //OR
    //they both hit null, so that's what will return if the loop cant detect the intersection
    return aPtr; 
};

