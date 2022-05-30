package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/30
 */
class N_104_MaximumDepthOfBinaryTreeTest {

    private final N_104_MaximumDepthOfBinaryTree solution = new N_104_MaximumDepthOfBinaryTree();

    @Test
    void maxDepth() {
        TreeNode root = new TreeNode(3, 9, 20, null, null, 15, 7);

        int maxDepth = solution.maxDepth(root);

        Assertions.assertEquals(3, maxDepth);
    }
}