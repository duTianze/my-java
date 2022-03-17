package com.dutainze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/3/18
 */
class N_2011_FinalValueOfVariableAfterPerformingOperationsTest {

    private final N_2011_FinalValueOfVariableAfterPerformingOperations solution = new N_2011_FinalValueOfVariableAfterPerformingOperations();

    @Test
    void finalValueAfterOperations() {
        String[] operations = {"--X","X++","X++"};
        int expect = 1;

        int actual = solution.finalValueAfterOperations(operations);
        Assertions.assertEquals(expect, actual);
    }
}
