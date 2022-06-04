package com.dutianze.algs.leetcode.tree;

/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">230. Kth Smallest Element in a BST</a>
 * <h2>Medium</h2>
 * <pre>
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 * Constraints:
 *
 *     The number of nodes in the tree is n.
 *     1 <= k <= n <= 104
 *     0 <= Node.val <= 104
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations)
 * and you need to find the kth smallest frequently, how would you optimize?
 * </pre>
 *
 * @author dutianze
 * @date 2022/6/4
 */
public class N_230_KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private int res = 0;
    private int rank = 0;

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
