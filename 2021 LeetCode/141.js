//this uses the hare and tortoise algo (Floyd algo --> to detect the cycle)
//two pointer approach
//fast moves by 2x
//slow moves by 1x
//and if there's a cycle they are destined to meet. 
var hasCycle = function(head) {
    //edge case (if only one node) or (no node at all)
    if(head === null || head.next === null) return false;
    else{
        let slow = head;
        let fast = head;
        
        //if will handle one node case and will check for the next node's next status
        //if the next node to fast has the next which equals null, we know it breaks the cycle
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow === fast) return true; 
        }
        return false;
    }
};
