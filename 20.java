//20. Valid Parentheses
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
*/

class Solution {
    
    public boolean isValid(String s) {
        if(s.length()%2 != 0 || s == null)
            return false;
        
        Stack<Integer> stack = new Stack<>();
        
        String open = "({[";
        String close = ")}]";
        
        for(char c: s.toCharArray())
        {
            if(open.indexOf(c) >= 0)
                stack.add(open.indexOf(c));
            else
            {
                if(stack.empty() || stack.pop() != close.indexOf(c))
                    return false;
            }
        }
        
        return stack.empty();
    }
}