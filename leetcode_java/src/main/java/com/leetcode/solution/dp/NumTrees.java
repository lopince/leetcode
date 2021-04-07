package com.leetcode.solution.dp;

public class NumTrees {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
    }

    private static class Solution {

        public int numTrees(int n) {

            if (n == 0 || n == 1 || n == 2) {
                return n;
            }

            // now n>2
            int[] dp = new int[n + 1];

            // base case
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= i; j++) {

                    dp[i] += (dp[j - 1] * dp[i - j]);
                }
            }

            return dp[n];
        }
    }
}
