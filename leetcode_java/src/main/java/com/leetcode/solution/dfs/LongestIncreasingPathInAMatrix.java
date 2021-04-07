package com.leetcode.solution.dfs;

public class LongestIncreasingPathInAMatrix {

    private static class Solution {
        public int longestIncreasingPath(int[][] matrix) {

            if (matrix == null || matrix.length == 0){
                return 0;
            }

            int[][] memo = new int[matrix.length][matrix[0].length];

            int ans = 1;
            for (int y = 0; y < matrix.length; y++) {
                for (int x = 0; x < matrix[0].length; x++) {
                    ans = Math.max(ans, dfs(matrix, memo, y, x));
                }
            }

            return ans;
        }

        private int dfs(int[][] matrix, int[][] memo, int y, int x) {

            if (memo[y][x] != 0) {
                return memo[y][x];
            }

            memo[y][x] = 1;

            // up
            if (y > 0 && matrix[y][x] < matrix[y - 1][x]) {
                memo[y][x] = Math.max(memo[y][x], dfs(matrix, memo, y - 1, x) + 1);
            }

            // down
            if (y < matrix.length - 1 && matrix[y][x] < matrix[y + 1][x]) {
                memo[y][x] = Math.max(memo[y][x], dfs(matrix, memo, y + 1, x) + 1);
            }

            // left
            if (x > 0 && matrix[y][x] < matrix[y][x - 1]) {
                memo[y][x] = Math.max(memo[y][x], dfs(matrix, memo, y, x - 1) + 1);
            }

            // right
            if (x < matrix[0].length - 1 && matrix[y][x] < matrix[y][x + 1]) {
                memo[y][x] = Math.max(memo[y][x], dfs(matrix, memo, y, x + 1) + 1);
            }

            return memo[y][x];
        }
    }
}
