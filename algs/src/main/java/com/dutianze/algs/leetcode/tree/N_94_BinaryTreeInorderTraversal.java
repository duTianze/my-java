package com.dutianze.algs.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">94. Binary Tree Inorder Traversal</a>
 * <h2>Easy</h2>
 * <pre>
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 100].
 *     -100 <= Node.val <= 100
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * </pre>
 *
 * @author dutianze
 * @date 2022/5/25
 */
public class N_94_BinaryTreeInorderTraversal {

    /**
     * 中序遍历  left -> root -> right
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode curr, List<Integer> result) {
        if (curr == null) {
            return;
        }
        inorderTraversal(curr.left, result);
        result.add(curr.val);
        inorderTraversal(curr.right, result);
    }
}
