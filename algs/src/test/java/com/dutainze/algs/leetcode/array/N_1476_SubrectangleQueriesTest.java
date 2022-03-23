package com.dutainze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/3/23
 */
class N_1476_SubrectangleQueriesTest {


    @Test
    void updateAndGetValueTest() {
        int[][] rectangle = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        N_1476_SubrectangleQueries n_1476_subrectangleQueries = new N_1476_SubrectangleQueries(rectangle);
        System.out.println(n_1476_subrectangleQueries);

        int actual = n_1476_subrectangleQueries.getValue(1, 2);
        Assertions.assertEquals(actual, 2);

        n_1476_subrectangleQueries.updateSubrectangle(0, 0, 2, 1, 7);
        System.out.println(n_1476_subrectangleQueries);
    }
}
