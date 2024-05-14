package com.dutianze.algs.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/4/1
 */
class N_123_BestTimeToBuyAndSellStockIIITest {

    private final N_123_BestTimeToBuyAndSellStockIII solution = new N_123_BestTimeToBuyAndSellStockIII();

    /**
     * Input: prices = [3,3,5,0,0,3,1,4]
     * Output: 6
     * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
     */
    @Test
    void maxProfit() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int maxProfit = solution.maxProfit(prices);
        Assertions.assertEquals(6, maxProfit);
    }
}