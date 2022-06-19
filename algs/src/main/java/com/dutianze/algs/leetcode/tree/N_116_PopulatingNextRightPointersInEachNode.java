package com.dutianze.algs.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">116. Populating Next Right Pointers in Each Node</a>
 * <h2></h2>
 * <pre>
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 *
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A),
 * your function should populate each next pointer to point to its next right node,
 * just like in Figure B. The serialized output is in level order as connected by the next pointers,
 * with '#' signifying the end of each level.
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 212 - 1].
 *     -1000 <= Node.val <= 1000
 *
 * Follow-up:
 *
 *     You may only use constant extra space.
 *     The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 * </pre>
 *
 * @author dutianze
 * @date 2022/6/11
 */
public class N_116_PopulatingNextRightPointersInEachNode {

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        this.connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        connectTwoNode(node1.right, node2.left);
    }

    public TreeNode connectWithQueue(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode pre = null;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (pre != null) {
                    pre.next = cur;
                }
                assert cur != null;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                pre = cur;
            }
        }
        return root;
    }
}
