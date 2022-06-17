package com.dutianze.algs.leetcode.tree;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">98. Validate Binary Search Tree</a>
 * <h2>Medium</h2>
 * <pre>
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *
 * Input: root = [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 104].
 *     -231 <= Node.val <= 231 - 1
 * </pre>
 *
 * @author dutianze
 * @date 2022/6/17
 */
public class N_98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
