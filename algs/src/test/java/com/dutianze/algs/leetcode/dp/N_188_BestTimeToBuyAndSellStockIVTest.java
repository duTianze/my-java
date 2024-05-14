package com.dutianze.algs.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/5/14
 */
class N_188_BestTimeToBuyAndSellStockIVTest {

    private final N_188_BestTimeToBuyAndSellStockIV solution = new N_188_BestTimeToBuyAndSellStockIV();

    @Test
    void maxProfit() {
        int maxProfit1 = solution.maxProfit(2, new int[]{2, 4, 1});
        Assertions.assertEquals(2, maxProfit1);

        int maxProfit2 = solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
        Assertions.assertEquals(7, maxProfit2);
    }
}