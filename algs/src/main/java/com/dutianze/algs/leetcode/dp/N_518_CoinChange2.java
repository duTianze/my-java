package com.dutianze.algs.leetcode.dp;

/**
 * <a href="https://leetcode.com/problems/coin-change-2/">518. Coin Change 2</a>
 * <h2>Medium</h2>
 * <pre>
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 *
 * Return the number of combinations that make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return 0.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * The answer is guaranteed to fit into a signed 32-bit integer.
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 *
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 * Constraints:
 *
 *     1 <= coins.length <= 300
 *     1 <= coins[i] <= 5000
 *     All the values of coins are unique.
 *     0 <= amount <= 5000
 * </pre>
 *
 * @author dutianze
 * @date 2022/5/19
 */
public class N_518_CoinChange2 {

    public int change(int amount, int[] coins) {
        // dp[i][j]  只使用前i个物品, 当背包容量为j时，有dp[i][j]种方法可以装满背包
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                // dp[i-1][j]              不使用第i个物品, 只使用前i-1个物品, 当背包容量为j时，有dp[i-1][j]种方法可以装满背包
                // dp[i][j-coins[i-1]]     使用第i个物品，物品数为i, 容量为j - coins[i-1], 此时dp[i][j-coins[i-1]]唯一确定dp[i][j]
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    public int changeCompress(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
