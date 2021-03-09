var addTwoNumbers = function(l1, l2) {
    //we are given two NON-EMPTY linked list and NON-NEGATIVE which solves most edge cases
    
    let ptr1 = l1;
    let ptr2 = l2;
    
    let val1 = 0, val2 = 0, sum = 0, carry = 0 , store = 0;
   
    //making a dummy node to connect all the sums
    let dummyNode = new ListNode(0);
    let dummyPtr = dummyNode;
    
    //looping till both of the nodes are empty
    //if one is empty and other's not, just put the value of that node to be 0
    while(ptr1 != null || ptr2 != null){
        
        //assigning the values to val# variables
        //and iterate the pointers inside conditionals
        //assigning val 1
        if(ptr1 != null){
            val1 = ptr1.val;
            ptr1 = ptr1.next;
        }else{
            val1 = 0;
        }
        
        //assigning val2
        if(ptr2 != null){
            val2 = ptr2.val;
            ptr2 = ptr2.next;
        }else{
            val2 = 0;
        }
        
        
        sum = val1 + val2 + carry;
        carry = Math.floor(sum / 10); //to calculate the carry and store it into a carry variable
        store = sum % 10;  // to store a remainder which is what will be used to set up new node

        //creating a new node --> to store the sum
        let node = new ListNode(store);
        dummyPtr.next = node;
        dummyPtr = dummyPtr.next;
    }    
    
    //we know if the left over node gets carried out then we
    //just add that to a new node
    if(carry){
        let node = new ListNode(carry);
        dummyPtr.next = node;
        dummyPtr = dummyPtr.next
    }
    
    return dummyNode.next;
    
};

