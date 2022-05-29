package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author dutianze
 * @date 2022/5/29
 */
class N_102_BinaryTreeLevelOrderTraversalTest {

    private final N_102_BinaryTreeLevelOrderTraversal solution = new N_102_BinaryTreeLevelOrderTraversal();

    @Test
    void levelOrder() {
        TreeNode root = new TreeNode(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> expected = List.of(List.of(3), List.of(9, 20), List.of(15, 7));

        List<List<Integer>> result = solution.levelOrder(root);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void levelOrderIteratively() {
        TreeNode root = new TreeNode(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> expected = List.of(List.of(3), List.of(9, 20), List.of(15, 7));

        List<List<Integer>> result = solution.levelOrderIteratively(root);

        Assertions.assertEquals(expected, result);
    }
}