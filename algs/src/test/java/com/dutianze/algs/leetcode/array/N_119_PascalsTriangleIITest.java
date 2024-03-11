package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author dutianze
 * @date 2024/3/12
 */
class N_119_PascalsTriangleIITest {

    private final N_119_PascalsTriangleII solution = new N_119_PascalsTriangleII();

    @Test
    void getRow() {

        List<Integer> row = solution.getRow(3);

        String resultStr = row.toString().replaceAll("\\s+", "");
        System.out.println(resultStr);
        Assertions.assertEquals("[1,3,3,1]", resultStr);
    }
}