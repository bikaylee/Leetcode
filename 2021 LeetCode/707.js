/**
 * Initialize your data structure here.
 */
var Node = function(data, next=null){
    this.data = data;
    this.next = next;  
}
var MyLinkedList = function() {
    this.head = null;
    this.length = 0;
};

/**
 * Get the value of the index-th node in the linked list. If the index is invalid, return -1. 
 * @param {number} index
 * @return {number}
 */
MyLinkedList.prototype.get = function(index) {
    if(index < 0 || index >= this.length) return -1;
    if(index === 0) return this.head.data;
    else{
        let temp = this.head;
        let i = 0;
        while(i < index){
            temp = temp.next;
            i++;
        } 
        return temp.data;
    }
};

/**
 * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtHead = function(val) {
    let node = new Node(val);
    if(this.head === null){
        this.head = node;
    }
    else{
        let temp = this.head;
        node.next = temp;
        this.head = node;
    }
    
    this.length++;
};

/**
 * Append a node of value val to the last element of the linked list. 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtTail = function(val) {
    let node = new Node(val);
    if(this.head === null){
        this.head = node;
    }else{
        let temp = this.head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;    
    }
    this.length++;
};

/**
 * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. 
 * @param {number} index 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtIndex = function(index, val) {
    if(index < 0 || index > this.length) return;
    let node = new Node(val)
    
    if(index === 0){
        if(this.head === null) this.head = node;
        else{
            let temp = this.head;
            node.next = temp;
            this.head = node
        }
    }
    else if(index === this.length){
        let temp = this.head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }else{
        let temp = this.head;
        let i = 0;
        while(i < index-1){
            temp = temp.next;
            i++;
        }
        let inNode = temp.next;
        node.next = inNode;
        temp.next = node;
    }
    this.length++;
};

/**
 * Delete the index-th node in the linked list, if the index is valid. 
 * @param {number} index
 * @return {void}
 */
MyLinkedList.prototype.deleteAtIndex = function(index) {
    if(index < 0 || index >= this.length) return;
    
    if(this.head.next === null && this.length === 1){
        if(index === 0) this.head = null;
    }else{
        
        let temp = this.head;
        if(index === 0){
            this.head = this.head.next;
            temp.next = null;
        }else{
            let i = 0;
            while(i < index-1){
                temp = temp.next;
                i++;
            }
            if(temp.next.next === null) temp.next = null; //to check if the next node is empty or not
            else{
                let delNode = temp.next;
                temp.next = delNode.next;
                delNode.next = null;
            }
        }
    }
    this.length--;
    ///
//     if (index < 0 || index >= length) return null;
//         let delNode = head; //we need this to return the node
//         //case where there's one node and we want to remove that node
//         if (length === 1 && index === 0) {
//             head = null;
//             length--;
//             return delNode.element;
//         }
//         else {
//             let i = 0;
//             while (i < index - 1) { //traverse to the node one less than the index provided
//                 delNode = delNode.next;
//                 i++;
//             }
//             let tempDel = delNode.next//one index higher than the current index;

//             if (index === length - 1) { //to check if the given index is the last index;
//                 delNode.next = null;
//                 length--;
//                 return tempDel.element;
//             } else {//if the given index is not the last index
//                 delNode.next = tempDel.next;
//                 tempDel.next = null;
//                 length--;
//                 return tempDel.element;
//             }
//         }

};

var obj = new MyLinkedList()
var param_1 = obj.get(0)
obj.addAtHead(2)
obj.addAtTail(19)
obj.addAtIndex(1,80)
obj.deleteAtIndex(1)

 
