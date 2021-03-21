//707. Design Linked List

class MyLinkedList {

    private ListNode head;
    private int size; 
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // System.out.println("size: " + this.size);
        // this.tostring();
        // System.out.println();
        
        ListNode curr = this.head;
        while(curr != null)
        {
            if(index-- == 0)
                return curr.val;
            curr = curr.next;
        }

        return -1;
    }
    
    public void tostring()
    {
        ListNode curr = this.head;
        while(curr != null)
        {
            // System.out.print(curr.val + " ");
            curr = curr.next;
        }
        // System.out.println();
    }
    
    public void addAtIndex(int index, int val) {
        if(index > this.size)
            return;
        
        ListNode newNode = new ListNode(val);
        
        if(index == 0 || this.size == 0)
        {
            newNode.next = this.head;
            this.head = newNode;
        }
        else
        {
            ListNode prev = null;
            ListNode curr = this.head;
            while(curr != null)
            {
                if(index == 0)
                    break;
                index--;
                prev = curr;
                curr = curr.next;
            }
            prev.next = newNode;
            newNode.next = curr;
        }
        this.size++;
    }

    public void addAtHead(int val) {
        this.addAtIndex(0, val);
    }
    
    
    public void addAtTail(int val) {
        this.addAtIndex(this.size, val);
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index == 0)
        {
            this.head = this.head.next;
            this.size -= 1;
        }
          
        else if(index >= this.size)
            return;
        else
        {
            ListNode prev = head;
            ListNode curr = head;
            while(curr != null)
            {
                if(index == 0)
                {
                    prev.next = curr.next;
                    break;
                }
                index--;
                prev = curr;
                curr = curr.next;
            }
            this.size -= 1;
        }
        
    }
}