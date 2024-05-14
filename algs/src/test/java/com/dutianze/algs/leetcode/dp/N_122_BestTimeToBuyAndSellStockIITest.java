package com.dutianze.algs.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/4/1
 */
class N_122_BestTimeToBuyAndSellStockIITest {

    private final N_122_BestTimeToBuyAndSellStockII solution = new N_122_BestTimeToBuyAndSellStockII();

    /**
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Total profit is 4 + 3 = 7.
     */
    @Test
    void maxProfit() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = solution.maxProfit(prices);
        Assertions.assertEquals(7, maxProfit);
    }
}