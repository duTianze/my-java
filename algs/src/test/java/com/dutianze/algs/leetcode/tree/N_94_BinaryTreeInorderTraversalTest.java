package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author dutianze
 * @date 2022/5/25
 */
class N_94_BinaryTreeInorderTraversalTest {

    private final N_94_BinaryTreeInorderTraversal solution = new N_94_BinaryTreeInorderTraversal();

    @Test
    void inorderTraversal() {
        TreeNode treeNode = TreeNode.createTree(1, null, 2, null, null, 3);

        List<Integer> result = solution.inorderTraversal(treeNode);

        Assertions.assertEquals(List.of(1, 3, 2), result);
    }

    @Test
    void inorderTraversalIterative() {
        TreeNode treeNode = TreeNode.createTree(1, null, 2, null, null, 3);

        List<Integer> result = solution.inorderTraversalIterative(treeNode);

        Assertions.assertEquals(List.of(1, 3, 2), result);
    }
}