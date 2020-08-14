package com.leetcode.question.dp;

public class BestTimeToBuyAndSellStock2 {

    private static class Solution {
        public int maxProfit(int[] prices) {

            int dp0 = 0;
            int dp1 = Integer.MIN_VALUE;

            for (int price : prices) {

                int pre0 = dp0;

                dp0 = Math.max(dp0, dp1 + price);
                dp1 = Math.max(dp1, pre0 - price);
            }

            return dp0;
        }
    }
}
