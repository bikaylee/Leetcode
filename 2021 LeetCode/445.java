//445. Add Two Numbers II

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode addTwoNumbersReversed(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode sum = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int n = 0, m = 0;
            if (l1 != null) {
                n = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                m = l2.val;
                l2 = l2.next;
            }
            sum = new ListNode((n + m + carry) % 10, sum);
            carry = (n + m + carry) / 10;
        }
        return carry == 1 ? new ListNode(carry, sum) : sum;
    }

    private ListNode reverse(ListNode head) {
        ListNode next = null;
        while (head != null) {
            ListNode prev = head.next;
            head.next = next;
            next = head;
            head = prev;
        }
        return next;
    }

    public ListNode addTwoNumbersNew(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.add(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.add(l2.val);
                l2 = l2.next;
            }
        }

        int carry = 0;
        ListNode sum = new ListNode(0);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();

            // System.out.println(n1 + " " + n2);

            sum.val = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            ListNode prev = new ListNode(0, sum);
            sum = prev;
        }
        if (carry > 0)
            sum.val = carry;
        else
            sum = sum.next;

        return sum;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> num1 = getNum(l1);
        List<Integer> num2 = getNum(l2);

        // System.out.println(num1.toString());
        // System.out.println(num2.toString());

        if (num1.size() == num2.size()) {
            for (int i = num1.size() - 1, j = num2.size() - 1; i >= 0; i--, j--)
                num1.set(i, num1.get(i) + num2.get(j));
        } else if (num1.size() < num2.size()) {
            for (int i = num1.size() - 1, j = num2.size() - 1; i >= 0; i--, j--)
                num2.set(j, num1.get(i) + num2.get(j));
            num1 = num2;
        } else {
            for (int i = num1.size() - 1, j = num2.size() - 1; j >= 0; i--, j--)
                num1.set(i, num1.get(i) + num2.get(j));
        }

        // System.out.println(num1.toString());
        for (int i = num1.size() - 1; i >= 0; i--) {
            if (num1.get(i) >= 10) {
                num1.set(i, num1.get(i) - 10);
                if (i == 0)
                    num1.add(0, 1);
                else
                    num1.set(i - 1, num1.get(i - 1) + 1);
            }
        }

        // System.out.println(num1.toString());

        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        for (int i = 0; i < num1.size(); i++) {
            ListNode newNode = new ListNode(num1.get(i));
            curr.next = newNode;
            curr = newNode;
        }

        return ans.next;
    }

    private List<Integer> getNum(ListNode node) {
        List<Integer> num = new ArrayList<>();

        ListNode curr = node;
        while (curr != null) {
            num.add(curr.val);
            curr = curr.next;
        }
        return num;
    }
}
