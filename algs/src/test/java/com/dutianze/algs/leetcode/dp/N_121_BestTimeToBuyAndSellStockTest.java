package com.dutianze.algs.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/3/31
 */
class N_121_BestTimeToBuyAndSellStockTest {

    private final N_121_BestTimeToBuyAndSellStock solution = new N_121_BestTimeToBuyAndSellStock();

    /**
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     */
    @Test
    void maxProfit() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = solution.maxProfit(prices);
        Assertions.assertEquals(5, maxProfit);
    }
}