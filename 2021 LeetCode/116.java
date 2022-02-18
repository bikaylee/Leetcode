/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    // At every level, connect all next level nodes 
    // and remember the first node of the next of next level
    
    // Since the previous level has been connected, 
    // use its next pointer to connect their children nodes
    
    
    
    public Node connect(Node root) {
        if (root == null)
            return null;

        Node curr = root;
        while (curr.left != null) {

            // Mark the start of every level - when traversing the next level, 
            //      the previous level is already linked and can be used as a linked list by calling its next pointer 
            Node start = curr.left;

            // Prev pointer is used for the connecting pointer of every subtree 
            // Ex: 
            //           1
            //         /   \ 
            //        2     3
            //       / \   / \
            //      4   5 6   7
            //          ^ 
            //        prev
            //
            // In this case, since we cannot retrieve the prev(5) by calling the current linkedlist (it's not doubly)
            // Then, all we need is to mark the prev node and link it with the next subtree's left child node 
            Node prev = null;

            // Here acts like a linked list traversal - to link the next level 
            // If it's the last level, there is no next level connection to be done
            while (curr != null) {

                // If it's the starting node, there is no prev node 
                if (prev != null)
                    prev.next = curr.left;

                curr.left.next = curr.right;
                prev = curr.right;
                curr = curr.next;
            }

            // Get the start of current level for the iteration of next level
            curr = start;
        }

        return root;
    }
    

    // Use queue to connect
    public Node connectQueue(Node root) {
        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize-- > 0) {
                Node curr = queue.poll();
                if (levelSize > 0)
                    curr.next = queue.peek();
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
        }

        return root;
    }
}