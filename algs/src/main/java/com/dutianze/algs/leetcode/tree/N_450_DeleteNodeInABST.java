package com.dutianze.algs.leetcode.tree;

/**
 * <a href="https://leetcode.com/problems/delete-node-in-a-bst/">450. Delete Node in a BST</a>
 * <h2>Medium</h2>
 * <pre>
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 *     Search for a node to remove.
 *     If the node is found, delete the node.
 *
 * Example 1:
 *
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,7], key = 0
 * Output: [5,3,6,2,4,null,7]
 * Explanation: The tree does not contain a node with value = 0.
 *
 * Example 3:
 *
 * Input: root = [], key = 0
 * Output: []
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 104].
 *     -105 <= Node.val <= 105
 *     Each node has a unique value.
 *     root is a valid binary search tree.
 *     -105 <= key <= 105
 *
 * Follow up: Could you solve it with time complexity O(height of tree)?
 *
 * </pre>
 *
 * @author dutianze
 * @date 2022/6/10
 */
public class N_450_DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = this.deleteNode(root.right, minNode.val);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
