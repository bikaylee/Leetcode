// 138. Copy List with Random Pointer

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomListNew(Node head) {
        if (head == null)
            return head;

        HashMap<Node, Node> visited = new HashMap<>();
        visited.put(head, new Node(head.val));

        Node curr = head;
        while (curr.next != null) {
            Node next = new Node(curr.next.val);
            visited.put(curr.next, next);
            visited.get(curr).next = next;
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node cloned = visited.get(curr);
            cloned.random = visited.get(curr.random);
            curr = curr.next;
        }

        return visited.get(head);

    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);

        HashMap<Node, Node> visited = new HashMap<>();
        visited.put(head, new Node(head.val));

        while (!queue.isEmpty()) {
            Node curr = queue.pop();
            Node cloned = visited.get(curr);
            if (curr.next != null) {
                if (!visited.containsKey(curr.next)) {
                    cloned.next = new Node(curr.next.val);
                    visited.put(curr.next, cloned.next);
                    queue.add(curr.next);
                } else {
                    cloned.next = visited.get(curr.next);
                }
            }

            if (curr.random != null) {
                if (!visited.containsKey(curr.random)) {
                    cloned.random = new Node(curr.random.val);
                    visited.put(curr.random, cloned.random);
                    if (curr.next != curr.random)
                        queue.add(curr.random);
                } else {
                    cloned.random = visited.get(curr.random);
                }
            }
            System.out.println(curr.val);
        }
        return visited.get(head);
    }
}