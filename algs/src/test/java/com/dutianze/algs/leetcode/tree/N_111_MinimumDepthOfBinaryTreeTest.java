package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/20
 */
class N_111_MinimumDepthOfBinaryTreeTest {

    private final N_111_MinimumDepthOfBinaryTree solution = new N_111_MinimumDepthOfBinaryTree();

    @Test
    void minDepth() {
        TreeNode root = new TreeNode(3, 9, 20, null, null, 15, 7);

        int minDepth = solution.minDepth(root);

        Assertions.assertEquals(2, minDepth);
    }
}