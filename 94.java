// 94. Binary Tree Inorder Traversal

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    // Iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // System.out.print(root.val + " ");
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // Recursive
    private ArrayList<Integer> ans;

    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList();
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }

}