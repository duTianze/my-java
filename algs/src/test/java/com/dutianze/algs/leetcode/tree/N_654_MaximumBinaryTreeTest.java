package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/10
 */
class N_654_MaximumBinaryTreeTest {

    private final N_654_MaximumBinaryTree solution = new N_654_MaximumBinaryTree();

    @Test
    void constructMaximumBinaryTree() {
        TreeNode expected = new TreeNode(6, 3, 5, null, 2, 0, null, null, 1);

        TreeNode result = solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});

        Assertions.assertEquals(expected.toString(), result.toString());
    }
}