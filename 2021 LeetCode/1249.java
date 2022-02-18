//1249. Minimum Remove to Make Valid Parentheses
/*
Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"
 

Constraints:

1 <= s.length <= 10^5
s[i] is one of  '(' , ')' and lowercase English letters.
*/

class Solution {

    public String minRemoveToMakeValidStack(String s) {
        Deque<Integer> stack = new ArrayDeque<>(); // store index of open paren
        Set<Integer> remove = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.addLast(i);
            else if (c == ')') {
                if (stack.isEmpty())
                    remove.add(i);
                else
                    stack.removeLast();
            }
        }

        // Any open paren in the front should be removed
        while (!stack.isEmpty()) {
            remove.add(stack.removeLast());
        }

        // skip all remove chars
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!remove.contains(i))
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = remove(s, '(', ')');
        sb = remove(sb.reverse().toString(), ')', '(');
        return sb.reverse().toString();
    }

    private StringBuilder remove(String s, char paren1, char paren2) {
        StringBuilder sb = new StringBuilder();
        int paren1Count = 0;
        int paren2Count = 0;
        for (char c : s.toCharArray()) {
            if (c == paren1) {
                paren1Count++;
                sb.append(c);
            } else if (c == paren2) {
                paren2Count++;
                if (paren2Count > paren1Count)
                    paren2Count--;
                else
                    sb.append(c);
            } else
                sb.append(c);
        }

        return sb;
    }
}