package com.leetcode.solution.dp;

import java.util.Arrays;

public class PerfectSquares {

    private static class Solution {
        public int numSquares(int n) {
            if (n < 2) {
                return n;
            }

            boolean[] isSqrt = new boolean[n + 1];
            Arrays.fill(isSqrt, false);
            for (int i = 1; i * i <= n; i++) {
                isSqrt[i * i] = true;
            }

            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {

                if (isSqrt[i]) {
                    dp[i] = 1;
                } else {
                    for (int j = 1; j * j < i; j++) {
                        dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                    }
                }
            }

            return dp[n];
        }
    }
}
