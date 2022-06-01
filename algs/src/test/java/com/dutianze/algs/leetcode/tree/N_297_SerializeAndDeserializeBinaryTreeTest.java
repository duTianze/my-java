package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/1
 */
class N_297_SerializeAndDeserializeBinaryTreeTest {

    private final N_297_SerializeAndDeserializeBinaryTree solution = new N_297_SerializeAndDeserializeBinaryTree();

    @Test
    void serializeAndDeserializeTest() {
        TreeNode root = new TreeNode(1, 2, 3, null, null, 4, 5);

        String serialize = solution.serialize(root);
        TreeNode deserializeRoot = solution.deserialize(serialize);

        Assertions.assertEquals(root.levelTraversal(), deserializeRoot.levelTraversal());
    }
}