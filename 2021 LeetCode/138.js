//naive approach is to store into a hashmap 
//iterate over each node and store that node
//creating a new node for the value with next = null & random = null;
//then loop again and set the nodes' next and ptr
//time O(n) and space O(n)
// var copyRandomList = function(head) {
//     if(head === null)return null;
    
//     let ptr = head;
//     let map = new Map();  //get and set
    
//     //first pass:
//     //to put each node in the map
//     while(ptr != null){
//         let node = new Node(ptr.val, null, null)
//         map.set(ptr, node);  //create node with only value
//         ptr = ptr.next;
//     }
    
//     //loop the actual node and compare and work with map nodes
//     //if next is null and random is null --> set it explicitly
//     //remember ptr will be pointing at the given node not the map 
//     ptr = head;
//     while(ptr != null){
//         //set the next first
//         if(ptr.next != null)
//             map.get(ptr).next = map.get(ptr.next);
//         else 
//             map.get(ptr).next = null;
        
//         //then set the random ptr;
//         if(ptr != null)
//             map.get(ptr).random = map.get(ptr.random);
//         else
//             map.get(ptr).random = null;
//         ptr = ptr.next;
//     }
    
//     return map.get(head) //return the new head node
// };



//efficient approach 
//would be to make node at each iterataion and point the new node to the existing node.next and //similarly the node will also be pointing at the new node
//more wiring needed
//first pass just make nodes
//then connect the next of duplicate nodes with old nodes and also the other way around
//then think about connecting the random pointer


var copyRandomList = function(head){
    if(head === null) return null;
    
    let ptr = head;
    
    //setting up the next value
    //connecting the nodes first 
    while(ptr!= null){
        let node = new Node(ptr.val, null, null);
        node.next = ptr.next
        ptr.next = node;
        ptr = ptr.next.next;
    }
    
    //since all the nodes are connected
    //time to connect the random ptrs
    ptr = head;
    while(ptr != null){
        //ptr.random.next was confusing
        //ptr.random points where? 
        //exactly after we see that node, we go node.next ? is what? 
        //so node.next is basically the duplicate node that we created and that is what we are
        //trying to set equal to
        ptr.next.random = ptr.random === null? null: ptr.random.next;  
        ptr = ptr.next.next;
    }
    
    //time to reconnect the nodes back;
    ptr = head;
    let dPtr = ptr.next;
    
    while(ptr.next  != null){
        let temp = ptr.next;
        ptr.next = ptr.next === null ? null : ptr.next.next;
        ptr = temp;
    }
    
    return dPtr;
}

