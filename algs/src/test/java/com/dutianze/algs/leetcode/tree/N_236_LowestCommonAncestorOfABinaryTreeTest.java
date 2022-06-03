package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/3
 */
class N_236_LowestCommonAncestorOfABinaryTreeTest {

    private final N_236_LowestCommonAncestorOfABinaryTree solution = new N_236_LowestCommonAncestorOfABinaryTree();

    @Test
    void lowestCommonAncestor() {
        TreeNode root = new TreeNode(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode p = root.findByVal(5);
        TreeNode q = root.findByVal(1);
        TreeNode expected = root.findByVal(3);

        TreeNode result = solution.lowestCommonAncestor(root, p, q);

        Assertions.assertEquals(expected, result);
    }
}