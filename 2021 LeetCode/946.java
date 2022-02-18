// 946. Validate Stack Sequences

/**
 * Input: pushed = `[1,2,3,4,5]`, popped = `[4,5,3,2,1]` Output: true
 * Explanation: We might do the following sequence: push(1), push(2), push(3),
 * push(4), pop() -> 4, push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 */

class Solution {
    /**
     * As the pushed array has not reached the popped element, keep pushing elements
     * in the pushed to the stack. If an element = the first element in popped, move
     * its pointer to the right until n. Keep check the if the top of the stack
     * equals the element by the pointer index element, then pop off the stack. The
     * final condition is that either the popped pointer reaches n or stack is
     * empty.
     * 
     * 
     * @param pushed
     * @param popped
     * @return boolean
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> st = new Stack();

        int j = 0;
        for (int p : pushed) {
            st.add(p);
            while (j < n && !st.isEmpty() && popped[j] == st.peek()) {
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }
}