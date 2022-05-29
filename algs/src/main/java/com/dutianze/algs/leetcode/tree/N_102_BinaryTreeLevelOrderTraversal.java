package com.dutianze.algs.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">102. Binary Tree Level Order Traversal</a>
 * <h2>Medium</h2>
 * <pre>
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 2000].
 *     -1000 <= Node.val <= 1000
 * </pre>
 *
 * @author dutianze
 * @date 2022/5/29
 */
public class N_102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderTraversal(root, result, 0);
        return result;
    }

    private void levelOrderTraversal(TreeNode curr, List<List<Integer>> result, int height) {
        if (curr == null) {
            return;
        }
        if (height == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(height).add(curr.val);
        levelOrderTraversal(curr.left, result, height + 1);
        levelOrderTraversal(curr.right, result, height + 1);
    }

    public List<List<Integer>> levelOrderIteratively(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
