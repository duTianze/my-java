package com.dutainze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/3/18
 */
class N_1672_RichestCustomerWealthTest {

    private final N_1672_RichestCustomerWealth solution = new N_1672_RichestCustomerWealth();

    @Test
    void maximumWealth() {
        int[][] accounts = {{1, 5}, {7, 3}, {3, 5}};
        int expect = 10;

        int actual = solution.maximumWealth(accounts);
        Assertions.assertEquals(expect, actual);
    }
}
