package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author dutianze
 * @date 2022/6/7
 */
class N_652_FindDuplicateSubtreesTest {

    private final N_652_FindDuplicateSubtrees solution = new N_652_FindDuplicateSubtrees();

    @Test
    void findDuplicateSubtrees() {
        TreeNode root = new TreeNode(1, 2, 3, 4, null, 2, 4, null, null, 4);
        List<List<Integer>> expected = new ArrayList<>() {{
            add(List.of(4));
            add(List.of(2, 4));
        }};

        List<TreeNode> duplicateSubtrees = solution.findDuplicateSubtrees(root);

        List<List<Integer>> result =
                duplicateSubtrees.stream()
                                 .map(t -> t.levelTraversal().stream().filter(Objects::nonNull)
                                            .collect(Collectors.toList()))
                                 .collect(Collectors.toList());
        System.out.println(duplicateSubtrees);

        Assertions.assertEquals(expected, result);
    }
}