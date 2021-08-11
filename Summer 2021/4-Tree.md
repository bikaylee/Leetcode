August 9, 2021

### Week 4 - Binary Tree

| No. | Problems                                                                                           | Diff | Day | Previous | Finished |
| --- | -------------------------------------------------------------------------------------------------- | ---- | --- | -------- | -------- |
| 1   | [230. Kth Smallest Element in a BST](#230-Kth-Smallest-Element-in-a-BST)                           | 🟠   | Mon |          | &check;  |
| 2   | [**98. Validate Binary Search Tree**](#98-Validate-Binary-Search-Tree)                             | 🟠   | Mon | &check;  | &check;  |
| 3   | [**110. Balanced Binary Tree**](#110-Balanced-Binary-Tree)                                         | 🟢   | Mon | &check;  | &check;  |
| 4   | [**101. Symmetric Tree**](#101-Symmetric-Tree)                                                     | 🟢   | Mon |          | &check;  |
| 5   | [102. Binary Tree Level Order Traversal](#102-Binary-Tree-Level-Order-Traversal)                   | 🟠   | Mon |          | &check;  |
|     |                                                                                                    |      |     |          |          |
| 6   | [107. Binary Tree Level Order Traversal II](#107-Binary-Tree-Level-Order-Traversal-II)             | 🟠   | Tue |          |          |
| 7   | [814. Binary Tree Pruning](#814-Binary-Tree-Pruning)                                               | 🟠   | Tue |          |          |
| 8   | [111. Minimum Depth of Binary Tree](#111-Minimum-Depth-of-Binary-Tree)                             | 🟢   | Tue |          |          |
| 9   | [226. Invert Binary Tree](#226-Invert-Binary-Tree)                                                 | 🟢   | Tue | &check;  |          |
| 10  | [199. Binary Tree Right Side View](#199-Binary-Tree-Right-Side-View)                               | 🟠   | Tue | &check;  |          |
|     |                                                                                                    |      |     |          |          |
| 11  | [652. Find Duplicate Subtrees](#652-Find-Duplicate-Subtrees)                                       | 🟠   | Wed |          |          |
| 12  | [508. Most Frequent Subtree Sum](#508-Most-Frequent-Subtree-Sum)                                   | 🟠   | Wed |          |          |
| 13  | [112. Path Sum](#112-Path-Sum)                                                                     | 🟢   | Wed |          |          |
| 14  | [113. Path Sum II](#113-Path-Sum-II)                                                               | 🟠   | Wed | &check;  |          |
| 15  | [1448. Count Good Nodes in Binary Tree](#1448-Count-Good-Nodes-in-Binary-Tree)                     | 🟠   | Wed |          |          |
|     |                                                                                                    |      |     |          |          |
| 16  | [114. Flatten Binary Tree to Linked List](#114-Flatten-Binary-Tree-to-Linked-List)                 | 🟠   | Thu |          |          |
| 17  | [173. Binary Search Tree Iterator](#173-Binary-Search-Tree-Iterator)                               | 🟠   | Thu |          |          |
| 18  | [515. Find Largest Value in Each Tree Row](#515-Find-Largest-Value-in-Each-Tree-Row)               | 🟠   | Thu | &check;  |          |
| 19  | [108. Convert Sorted Array to Binary Search Tree](#108-Convert-Sorted-Array-to-Binary-Search-Tree) | 🟢   | Thu |          |          |
| 20  | [938. Range Sum of BST](#938-Range-Sum-of-BST)                                                     | 🟢   | Thu | &check;  |          |
|     |                                                                                                    |      |     |          |          |
| 21  | [449. Serialize and Deserialize BST](#449-Serialize-and-Deserialize-BST)                           | 🟠   | Fri |          |          |
| 22  | [297. Serialize and Deserialize Binary Tree](#297-Serialize-and-Deserialize-Binary-Tree)           | 🔴   | Fri |          |          |
| 23  | [617. Merge Two Binary Trees](#617-Merge-Two-Binary-Trees)                                         | 🟢   | Fri |          |          |
| 24  | [572. Subtree of Another Tree](#572-Subtree-of-Another-Tree)                                       | 🟢   | Fri | &check;  |          |
| 25  | [543. Diameter of Binary Tree](#543-Diameter-of-Binary-Tree)                                       | 🟢   | Fri | &check;  |          |

**TODO:**

- **98. Validate Binary Search Tree**
- **110. Balanced Binary Tree**
- **101. Symmetric Tree**

<br>

## Monday

### [230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

Given the `root` of a binary search tree, and an integer k, return the `kth (1-indexed)` smallest element in the tree.

#### Approach 1: (Priority Queue)

- Inorder to find the Kth smallest element, traverse the whole tree and put every node's value into a priority queue

  ```java
  // Time: O(n log n)
  // Space: O(n)
  class Solution {
      private Queue<Integer> queue = new PriorityQueue<>();

      public int kthSmallest(TreeNode root, int k) {
          traverse(root);
          return getKth(k);
      }

      private void traverse(TreeNode root) {
          if (root == null) return;
          queue.add(root.val);
          traverse(root.left);
          traverse(root.right);
      }

      private int getKth(int k) {
          while (k-- > 1 && !queue.isEmpty())
              queue.poll();
          return queue.isEmpty()? -1:queue.poll();
      }
  }
  ```

#### Approach 2:

- The inorder traversal of a BST is in sorted increasing order
  ```java
  // Time: O(n)
  // Space: O(n)
  class Solution {
      private ArrayList<Integer> list = new ArrayList<Integer>();
      public int kthSmallest(TreeNode root, int k) {
          traverse(root);
          return list.get(k-1);
      }
      // inorder traverseal of a BST is sorted
      private void traverse(TreeNode root) {
          if (root == null)
              return;
          traverse(root.left);
          list.add(root.val);
          traverse(root.right);
      }
  }
  ```

<br>

### [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)

<br>

### [110. Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)

<br>

### [101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)

<br>

### [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Input: root = `[3,9,20,null,null,15,7]`  
Output: `[[3],[9,20],[15,7]]`

#### Approach:

- Level order is BFS, every level is saved to the temporary queue. Before getting to the children of the nodes in queue, record all parent node value of current level.

  ```java
  // Time: O(n)
  // Space: O(n)
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      if (root == null) return res;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
          int n = queue.size();
          List<Integer> level = new ArrayList<>();
          TreeNode curr = null;
          while (n-- > 0) {
              curr = queue.poll();
              level.add(curr.val);
              if (curr.left != null) queue.add(curr.left);
              if (curr.right != null)  queue.add(curr.right);
          }
          res.add(level);
      }
      return res;
  }
  ```

<br>
<br>

## Tuesday

### [107. Binary Tree Level Order Traversal II(https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)

Given the `root` of a binary tree, return the **bottom-up** level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

Input: root = `[3,9,20,null,null,15,7]`  
Output: `[[3],[9,20],[15,7]]`

#### Approach 1: (BFS iterative)

- Same idea from the previous problem, but in reverse order for levels. Then, just insert to front for every level. Or reverse the return list at the end.

  ```java
  // Time: O(n)
  // Space: O(n)
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      if (root == null) return res;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
          int n = queue.size();
          List<Integer> level = new ArrayList<>();
          TreeNode curr = null;
          while (n-- > 0) {
              curr = queue.poll();
              level.add(curr.val);
              if (curr.left != null) queue.add(curr.left);
              if (curr.right != null)  queue.add(curr.right);
          }
          res.add(0, level);
      }
      return res;
  }
  ```

#### Approach 2: (Recursion)

- TO BE ADDED

<br>

### [814. Binary Tree Pruning()

<br>

### [111. Minimum Depth of Binary Tree()

<br>

### [226. Invert Binary Tree()

<br>

### [199. Binary Tree Right Side View()

<br>

<br>

## Wednesday

### [652. Find Duplicate Subtrees]()

<br>

### [508. Most Frequent Subtree Sum()

<br>

### [112. Path Sum()

<br>

### [113. Path Sum II()

<br>

### [1448. Count Good Nodes in Binary Tree()

<br>
<br>

## Thursday

### [114. Flatten Binary Tree to Linked List]()

<br>

### [173. Binary Search Tree Iterator]()

<br>

### [515. Find Largest Value in Each Tree Row]()

<br>

### [108. Convert Sorted Array to Binary Search Tree]()

<br>

### [938. Range Sum of BST]()

<br>
<br>

## Friday

### [449. Serialize and Deserialize BST]()

Question

#### Approach

- Explanation, ideas
  ```java
    // code
  ```

<br>

### [297. Serialize and Deserialize Binary Tree]()

<br>

### [617. Merge Two Binary Trees]()

<br>

### [572. Subtree of Another Tree]()

<br>

### [543. Diameter of Binary Tree]()

<br>
