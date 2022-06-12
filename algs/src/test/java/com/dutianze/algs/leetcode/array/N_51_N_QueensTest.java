package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author dutianze
 * @date 2022/6/13
 */
class N_51_N_QueensTest {

    private final N_51_N_Queens solution = new N_51_N_Queens();

    @Test
    void solveNQueens() {
        List<List<String>> lists = solution.solveNQueens(8);
        Assertions.assertEquals(92, lists.size());
    }
}