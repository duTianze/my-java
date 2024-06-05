package com.dutianze.algs.leetcode.dp;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/">309. Best Time to Buy and Sell Stock with Cooldown</a>
 * <pre>
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 * Constraints:
 *
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 *
 * </pre>
 *
 * @author dutianze
 * @date 2024/5/14
 */
public class N_309_BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }

    int maxProfit_with_cool(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case 1
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if (i - 2 == -1) {
                // base case 2
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                // i - 2 小于 0 时根据状态转移方程推出对应 base case
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
                //   dp[i][1]
                // = max(dp[i-1][1], dp[-1][0] - prices[i])
                // = max(dp[i-1][1], 0 - prices[i])
                // = max(dp[i-1][1], -prices[i])
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
