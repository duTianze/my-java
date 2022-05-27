package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author dutianze
 * @date 2022/5/27
 */
class N_144_BinaryTreePreorderTraversalTest {

    private final N_144_BinaryTreePreorderTraversal solution = new N_144_BinaryTreePreorderTraversal();

    @Test
    void preorderTraversal() {
        TreeNode treeNode = new TreeNode(1, null, 2, 3);

        List<Integer> result = solution.preorderTraversal(treeNode);

        Assertions.assertEquals(List.of(1, 2, 3), result);
    }
}