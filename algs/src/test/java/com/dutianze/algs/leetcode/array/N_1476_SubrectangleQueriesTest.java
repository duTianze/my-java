package com.dutianze.algs.leetcode.array;

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

        int actual7 = n_1476_subrectangleQueries.getValue(0, 1);
        Assertions.assertEquals(actual7, 7);
    }

    @Test
    void updateAndGetValueHistoryTest() {
        int[][] rectangle = {{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}};
        N_1476_SubrectangleQueries n_1476_subrectangleQueries = new N_1476_SubrectangleQueries(rectangle);
        System.out.println(n_1476_subrectangleQueries);

        int actual1 = n_1476_subrectangleQueries.getValueHistory(0, 2);
        Assertions.assertEquals(actual1, 1);

        n_1476_subrectangleQueries.updateSubrectangleHistory(0, 0, 3, 2, 5);
        System.out.println(n_1476_subrectangleQueries);

        int actual2 = n_1476_subrectangleQueries.getValueHistory(0, 2);
        Assertions.assertEquals(actual2, 5);

        int actual3 = n_1476_subrectangleQueries.getValueHistory(3, 1);
        Assertions.assertEquals(actual3, 5);

        n_1476_subrectangleQueries.updateSubrectangleHistory(3, 0, 3, 2, 10);
        System.out.println(n_1476_subrectangleQueries);

        int actual4 = n_1476_subrectangleQueries.getValueHistory(3, 1);
        Assertions.assertEquals(actual4, 10);

        int actual5 = n_1476_subrectangleQueries.getValueHistory(0, 2);
        Assertions.assertEquals(actual5, 5);
    }
}
