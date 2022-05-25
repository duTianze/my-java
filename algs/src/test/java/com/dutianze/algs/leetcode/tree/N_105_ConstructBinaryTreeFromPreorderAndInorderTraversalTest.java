package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/5/26
 */
class N_105_ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    private final N_105_ConstructBinaryTreeFromPreorderAndInorderTraversal solution =
            new N_105_ConstructBinaryTreeFromPreorderAndInorderTraversal();

    @Test
    void buildTree() {
        List<Integer> expected = Arrays.stream(new Integer[]{3, 9, 20, null, null, 15, 7}).toList();

        TreeNode result = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        Assertions.assertEquals(expected, result.levelTraversal());
    }

}