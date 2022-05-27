package com.dutianze.algs.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">144. Binary Tree Preorder Traversal</a>
 * <h2>Easy</h2>
 * <pre>
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
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
 * @date 2022/5/27
 */
public class N_144_BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(TreeNode curr, List<Integer> result) {
        if (curr == null) {
            return;
        }
        result.add(curr.val);
        preorderTraversal(curr.left, result);
        preorderTraversal(curr.right, result);
    }
}
