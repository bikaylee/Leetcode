//445. Add Two Numbers II

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> num1 = getNum(l1);
        List<Integer> num2 = getNum(l2);
                
//         System.out.println(num1.toString());
//         System.out.println(num2.toString());
        
        if(num1.size() == num2.size())
        {
            for(int i = num1.size()-1, j = num2.size()-1; i >= 0; i--, j--)
                num1.set(i,num1.get(i) + num2.get(j));
        }
        else if(num1.size() < num2.size())
        {
            for(int i = num1.size()-1, j = num2.size()-1; i >= 0; i--, j--)
                num2.set(j, num1.get(i) + num2.get(j));
            num1 = num2;
        }
        else
        {
            for(int i = num1.size()-1, j = num2.size()-1; j >= 0; i--, j--)
                num1.set(i, num1.get(i) + num2.get(j));
        }
        
        // System.out.println(num1.toString());
        for(int i = num1.size()-1; i >= 0; i--)
        {
            if(num1.get(i) >= 10)
            {
                num1.set(i, num1.get(i)-10);
                if(i == 0)
                    num1.add(0, 1);
                else
                    num1.set(i-1, num1.get(i-1)+1);
            }
        }
        
        // System.out.println(num1.toString());
        
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        for(int i = 0; i < num1.size(); i++)
        {
            ListNode newNode = new ListNode(num1.get(i));
            curr.next = newNode;
            curr = newNode;
        }
        
        return ans.next;
    }
    
    private List<Integer> getNum(ListNode node)
    {
        List<Integer> num = new ArrayList<>();
        
        ListNode curr = node;
        while(curr != null)
        {
            num.add(curr.val);
            curr = curr.next;
        }
        return num;
    }
}
