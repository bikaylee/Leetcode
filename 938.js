/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
var rangeSumBST = function (root, low, high) {
    let sum = 0;

    function helper(r) {
        if (r === null) {
            return;
        }

        if (high >= r.val && r.val >= low) {
            sum += r.val;
        }
        //if the r.val > low -->  left
        if (r.val > low) {
            helper(r.left)
        }
        //if the r.val < high --> right
        if (r.val < high) {
            helper(r.right)
        }
    }

    helper(root)
    return sum;
};