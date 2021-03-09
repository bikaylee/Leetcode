//instead of using recursion --> i'll use stack data structure and iteration
//we know stack first in last out
//once I see the child pointing to something, the current nodes' next will be pushed inside the stack
//after the current nodes next is empty we can start popping it.
var flatten = function(head) {
    
    if(head === null) return null  //if empty
    
    if(head.next === null && head.child === null) return head; //if single node
    
    //if more than one node
    let curr = head;
    let stack = []; //useful to store the lists when working with nodes cotaining child's lists
    
    while(curr != null){
        //case when the node's child is not null
        //we are going to go deep inside it and storing whatever next element in stack for later use
        if(curr.child != null){
            if(curr.next != null){     //only assign after checking the next, if next is null no stack 
                stack.push(curr.next);
            }
            curr.next = curr.child;
            curr.child.prev = curr; 
            curr.child = null;  //Important to make sure the child ptrs are set to null
        }
        
        //making sure that the popped items is assigned to a variable
        else {
            if(curr.next === null && stack.length){
                let backUpNodes = stack.pop();
                curr.next = backUpNodes;
                backUpNodes.prev = curr;
            }  
        }
        curr = curr.next;
    }

    return head;
};

