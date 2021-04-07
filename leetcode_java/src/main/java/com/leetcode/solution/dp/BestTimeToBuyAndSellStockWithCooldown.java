package com.leetcode.solution.dp;

public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {

        int[] prices = new int[]{1, 2, 3, 0, 2};

        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }

    private static class Solution {

        public int maxProfit(int[] prices) {

            if (prices == null || prices.length == 0) {
                return 0;
            }

            int n = prices.length;

            // dp[i][0] 持有股票，第i天的最大收益
            // dp[i][1] 不持有股票，处于冷冻期，第i天的最大收益
            // dp[i][2] 不持有股票，不处于冷冻期，第i天的最大收益
            int[][] dp = new int[n][3];

            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            dp[0][2] = 0;

            for (int i = 1; i < n; i++) {

                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                dp[i][1] = dp[i - 1][0] + prices[i];
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }

            return Math.max(dp[n - 1][1], dp[n - 1][2]);
        }
    }
}
