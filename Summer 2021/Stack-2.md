July 29, 2021

### Week 2 - Stack

| No. | Problems                                                               | Diff | Day | Previous | Finished |
| --- | ---------------------------------------------------------------------- | ---- | --- | -------- | -------- |
| 1   | [946. Validate Stack Sequences](#946-Validate-Stack-Sequences)         | 🟠   | Thu |          | &check;  |
| 2   | [907. Sum of Subarray Minimums](#907-Sum-of-Subarray-Minimums)         | 🟠   | Thu |          |          |
| 3   | [20. Valid Parentheses](#20-Valid-Parentheses)                         | 🟢   | Thu | &check;  | &check;  |
| 4   | [232. Implement Queue using Stacks](#232-Implement-Queue-using-Stacks) | 🟢   | Thu |          | &check;  |
| 5   | [71. Simplify Path](#71-Simplify-Path)                                 | 🟠   | Thu |          | &check;  |

<br>

## Thursday

### [946. Validate Stack Sequences](https://leetcode.com/problems/validate-stack-sequences/)

Input: pushed = `[1,2,3,4,5]`, popped = `[4,5,3,2,1]`  
Output: true  
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,  
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

#### Approach

- As the pushed array has not reached the popped element, keep pushing elements in the pushed to the stack. If an element = the first element in popped, move its pointer to the right until n. Keep check the if the top of the stack equals the element by the pointer index element, then pop off the stack. The final condition is that either the popped pointer reaches n or stack is empty.

  ```java
  // Time: O(n)
  // Space: O(n)
  public boolean validateStackSequences(int[] pushed, int[] popped) {
  int n = pushed.length;
  Stack<Integer> st = new Stack();

  int j = 0;
  for (int p : pushed) {
      st.add(p);
      while(j < n && !st.isEmpty() && popped[j] == st.peek()) {
          st.pop();
          j++;
      }
  }
  return st.isEmpty();
  }
  ```

<br>

### [907. Sum of Subarray Minimums](https://leetcode.com/problems/sum-of-subarray-minimums)

Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 10^9 + 7.

Input: arr = `[3,1,2,4]`  
Output: `17`  
Explanation:  
Subarrays are `[3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].`  
Minimums are `3, 1, 2, 4, 1, 1, 2, 1, 1, 1.`

#### Approach

- Look over videos for explanation
- In every subset of integer, expand to left and right until no more elements are greater than itself or reaches the boudary. Then, every subset's minimum should be the product of including itself to the left and the right will output the current sum of this subset and every subsets within the current subset.

  ```java
  // Time: O(n^2)
  // Space: O(1)
  public int sumSubarrayMins(int[] arr) {
      final int kMod = 1000000007;
      final int n = arr.length;
      int ans = 0;

      for (int i = 0; i < n; ++i) {
          int left = 0;
          for (int j = i - 1; j >= 0 && arr[j] > arr[i]; --j, ++left);

          int right = 0;
          for (int j = i + 1; j < n && arr[j] >= arr[i]; ++j, ++right);

          ans = (int)((ans + (long)arr[i] * (left + 1) * (right + 1)) % kMod);
          // System.out.println("left: " + left + "\nright: " + right + "\nans: " + ans + "\n");
      }

      return ans;
  }
  ```

<br>

### [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

Given a string s containing just the characters `'(', ')', '{', '}', '[' and ']'`, determine if the input string is valid.

#### Approach

- Using stack to store all open paren. The next closing paren should be matching the one just popped off the stack. According to the ascii table, closing and openning are either one or two characters away. One case is more closing paren in front of the openning, check if there is any openning in the stack. Lastly, if all paren are matching, the stack should be empty. If the stack is not empty, it means there are more open paren than it should be.

  ```java
  // Time: O(n)
  // Space: O(n)
  public boolean isValid(String s) {
      if (s.length()%2 == 1) return false;

      Stack<Character> st = new Stack();
      for (char c: s.toCharArray()) {
          if (c == '[' || c == '(' || c == '{')
              st.add(c);
          else {
              if (st.isEmpty() || Math.abs(c - st.pop()) > 2)
                  return false;
          }
      }
      return st.empty();
  }
  ```

<br>

### [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

#### Approach

- Use two stacks and memorized front holder. The main stack is the first stack and the second stack is the reversed (Queue) structured.

  - `Push` - O(1) to add new element to the first.
    - If the first stack is empty, it's been either popped or originally empty.
    - Else, there has not been popped

  ```java
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
  ```

<br>

### [71. Simplify Path](https://leetcode.com/problems/simplify-path/)

Given a string path, which is an **absolute path** (starting with a slash `/`) to a file or directory in a Unix-style file system, convert it to the simplified **canonical path**.

Input: path = `"/a/./b/../../c/"`  
Output: `"/c"`

#### Approach

- First, split the string by the delimiter slash `/`. Iterate through the split array, if there any `..` which means up a level, then pop the top directory off the stack. If the element is null or equals `.` which means stay on the current directory, then ignore. What's left over in the stack is the path in canonical.

  ```java
  // Time: O(n)
  // Space: O(n)
  public String simplifyPath(String path) {

      String[] arr = path.split("/");
      Stack<String> st = new Stack();

      for (String s: arr) {
          if (s.length() == 0 || s.equals("."))
              continue;
          else if (s.equals("..")) {
              if(!st.isEmpty())
                  st.pop();
          }
          else
              st.add(s);
      }

      String res = "";
      while (!st.isEmpty()) {
          res = "/" +  st.pop() + res;
      }

      return res.length() > 0 ? res:"/";
  }
  ```

<br>
<br>

## Friday
