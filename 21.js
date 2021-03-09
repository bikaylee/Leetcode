//approach 
//create a dummy node and then link all the given nodes to it
//since its' a sorted list, gotta make sure to also keep the nodes all sorted
//so keeping two pointers for each l1 and l2 can help
//we will make sure to start checking for each node's value 
//tie in the lower value to the dummy node and move the respective ptrs from l1 and l2
var mergeTwoLists = function(l1, l2) {
    
    //initial checks
    if(l1 === null && l2 === null) return null; //case where there's no node
    if(l1 === null) return l2;  //case when only one list is present
    if(l2 === null) return l1;  //case when only one list is present
    
    let ptr1 = l1;
    let ptr2 = l2;
    let dummyNode = new ListNode(0); //creating a dummy node;
    let dummyPtr = dummyNode;
    
    //we will loop until the both nodes are not empty
    //if one node ptr is empty we stop the loop and tie it the remaining nodes to the dummyNode
    
    while(ptr1 != null && ptr2 != null){
        //if the l1 nodes val is less then we tie this node before the l2 node
        //else l2 nodes will tie on to dummyNode before l1
        if(ptr1.val < ptr2.val){
            dummyPtr.next = ptr1;
            ptr1 = ptr1.next;
        }
        else{
            dummyPtr.next = ptr2;
            ptr2 = ptr2.next;
        }
        
        dummyPtr = dummyPtr.next;
    }
    //case when one of the nodes has extra remaining nodes
    if(ptr1 != null){
        dummyPtr.next = ptr1;
    }
    if(ptr2 != null){
        dummyPtr.next = ptr2;
    }
    return dummyNode.next;
    
};

