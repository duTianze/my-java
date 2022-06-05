package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/5
 */
class N_226_InvertBinaryTreeTest {

    private final N_226_InvertBinaryTree solution = new N_226_InvertBinaryTree();

    @Test
    void invertTree() {
        TreeNode root = new TreeNode(4, 2, 7, 1, 3, 6, 9);
        TreeNode expected = new TreeNode(4, 7, 2, 9, 6, 3, 1);

        TreeNode output = solution.invertTree(root);

        Assertions.assertEquals(expected.toString(), output.toString());
    }
}