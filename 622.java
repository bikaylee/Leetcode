// 622. Design Circular Queue

class MyCircularQueue {
    int front;
    int rear;
    int n;

    int[] queue;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.front = -1;
        this.rear = -1;
        this.n = k - 1;
    }

    public boolean enQueue(int value) {
        if (this.isFull())
            return false;

        if (rear < this.n) {
            rear++;
            front = front == -1 ? rear : front;
        } else if (rear == this.n && front > 0) {
            rear = 0;
        }
        queue[rear] = value;

        return true;
    }

    public boolean deQueue() {
        if (this.isEmpty())
            return false;

        queue[front] = 0;

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            if (front < this.n) {
                front++;
            } else if (front == this.n) {
                front = 0;
            }
        }

        return true;
    }

    public int Front() {
        if (this.front == -1)
            return -1;
        return queue[this.front];
    }

    public int Rear() {
        if (this.rear == -1)
            return -1;
        return queue[this.rear];
    }

    public boolean isEmpty() {
        return this.front == -1 && this.rear == -1;
    }

    public boolean isFull() {
        return !this.isEmpty() && (this.rear - this.front == this.n || this.front - this.rear == 1);
    }
}

/**
 * class MyCircularQueue {
 * 
 * private int[] queue; private int headIndex; private int count; private int
 * capacity;
 * 
 * // Initialize your data structure here. Set the size of the queue to be k.
 * public MyCircularQueue(int k) { this.capacity = k; this.queue = new int[k];
 * this.headIndex = 0; this.count = 0; }
 * 
 * // Insert an element into the circular queue. Return true if the operation is
 * successful. public boolean enQueue(int value) { if (this.count ==
 * this.capacity) return false; this.queue[(this.headIndex + this.count) %
 * this.capacity] = value; this.count += 1; return true; }
 * 
 * // Delete an element from the circular queue. Return true if the operation is
 * successful. public boolean deQueue() { if (this.count == 0) return false;
 * this.headIndex = (this.headIndex + 1) % this.capacity; this.count -= 1;
 * return true; }
 * 
 * // Get the front item from the queue. public int Front() { if (this.count ==
 * 0) return -1; return this.queue[this.headIndex]; }
 * 
 * // Get the last item from the queue. public int Rear() { if (this.count == 0)
 * return -1; int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
 * return this.queue[tailIndex]; }
 * 
 * // Checks whether the circular queue is empty or not. public boolean
 * isEmpty() { return (this.count == 0); }
 * 
 * // Checks whether the circular queue is full or not. public boolean isFull()
 * { return (this.count == this.capacity); } }
 */

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */