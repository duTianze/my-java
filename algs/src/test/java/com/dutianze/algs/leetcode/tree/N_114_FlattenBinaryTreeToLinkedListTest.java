package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/6
 */
class N_114_FlattenBinaryTreeToLinkedListTest {

    private final N_114_FlattenBinaryTreeToLinkedList solution = new N_114_FlattenBinaryTreeToLinkedList();

    @Test
    void flatten() {
        TreeNode root = new TreeNode(1, 2, 5, 3, 4, null, 6);
        TreeNode expected = new TreeNode(1, null, 2, null, 3, null, 4, null, 5, null, 6);

        solution.flatten(root);

        Assertions.assertEquals(expected, root);
    }
}