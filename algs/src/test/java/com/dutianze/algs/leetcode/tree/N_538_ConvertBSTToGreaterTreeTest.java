package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/14
 */
class N_538_ConvertBSTToGreaterTreeTest {

    private final N_538_ConvertBSTToGreaterTree solution = new N_538_ConvertBSTToGreaterTree();

    @Test
    void convertBST() {
        TreeNode root = new TreeNode(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);
        TreeNode expected = new TreeNode(30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8);

        TreeNode result = solution.convertBST(root);

        Assertions.assertEquals(expected.toString(), result.toString());
    }
}