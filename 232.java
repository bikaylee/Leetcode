// 232. Implement Queue using Stacks

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The
 * implemented queue should support all the functions of a normal queue (push,
 * peek, pop, and empty).
 * 
 */

/**
 * - Use two stacks and memorized front holder. The main stack is the first
 * stack and the second stack is the reversed (Queue) structured.
 * 
 * - `Push` - O(1) to add new element to the first.
 * 
 * - If the first stack is empty, it's been either popped or originally empty.
 * 
 * - Else, there has not been popped
 */
class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private Integer front;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
        front = null;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty())
            front = x;
        s1.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.add(s1.pop());
            }
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
