package com.leetcode.solution;

import java.util.Arrays;

public class PerfectSquares {

    public static void main(String[] args) {

        int n = 13;

        Solution solution = new Solution();
        System.out.println(solution.numSquares(n));
    }

    private static class Solution {

        public int numSquares(int n) {

            if (n < 4){
                return n;
            }

            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                }
            }

            return dp[n];
        }
    }
}
