package com.leetcode.shopee;

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {

        int num = 5;

        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
    }

    private static class Solution {

        public int numTrees(int n) {

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {

                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }

            return dp[n];
        }
    }
}
