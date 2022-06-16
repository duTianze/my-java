package com.dutianze.algs.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/range-sum-of-bst/">938. Range Sum of BST</a>
 * <h2>Easy</h2>
 * <pre>
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 *
 * Example 2:
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 2 * 104].
 *     1 <= Node.val <= 105
 *     1 <= low <= high <= 105
 *     All Node.val are unique.
 * </pre>
 *
 * @author dutianze
 * @date 2022/6/16
 */
public class N_938_RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                assert cur != null;
                if (cur.val >= low && cur.val <= high) {
                    sum += cur.val;
                }
                if (cur.left != null && cur.val >= low) {
                    queue.offer(cur.left);
                }
                if (cur.right != null && cur.val <= high) {
                    queue.offer(cur.right);
                }
            }
        }
        return sum;
    }

    public int rangeSumBSTRecursion(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBSTRecursion(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBSTRecursion(root.right, low, high);
        }
        return root.val + rangeSumBSTRecursion(root.left, low, high) + rangeSumBSTRecursion(root.right, low, high);
    }
}
