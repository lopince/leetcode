package com.leetcode.solution.dp;

public class MaximalSquare {

    private static class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }

            int maxY = matrix.length;
            int maxX = matrix[0].length;
            int max = 0;


            int[][] dp = new int[maxY][maxX];
            for (int i = 0; i < maxY; i++) {
                if (matrix[i][0] == '1') {
                    dp[i][0] = 1;
                    max = 1;
                }
            }
            for (int i = 0; i < maxX; i++) {
                if (matrix[0][i] == '1') {
                    dp[0][i] = 1;
                    max = 1;
                }
            }

            for (int y = 1; y < maxY; y++) {
                for (int x = 1; x < maxX; x++) {

                    if (matrix[y][x] == '0') {
                        dp[y][x] = 0;
                    } else {

                        dp[y][x] =
                                Math.min(
                                        dp[y - 1][x],
                                        Math.min(
                                                dp[y][x - 1],
                                                dp[y - 1][x - 1])) + 1;

                        if (max < dp[y][x]) {
                            max = dp[y][x];
                        }
                    }
                }
            }

            return max * max;
        }
    }
}
