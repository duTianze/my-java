package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author dutianze
 * @date 2024/3/8
 */
class N_118_PascalsTriangleTest {

    private final N_118_PascalsTriangle solution = new N_118_PascalsTriangle();

    @Test
    void generate() {
        List<List<Integer>> result = solution.generate(5);
        String resultStr = result.toString().replaceAll("\\s+", "");
        System.out.println(resultStr);
        Assertions.assertEquals("[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]", resultStr);
    }
}