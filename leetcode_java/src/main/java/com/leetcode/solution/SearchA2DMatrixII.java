package com.leetcode.solution;

public class SearchA2DMatrixII {

    private static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0){
                return false;
            }

            int maxX = matrix[0].length;
            int maxY = matrix.length;

            int x = maxX / 2;
            int y = maxY / 2;

            boolean[][] sentinel = new boolean[maxY][maxX];
            for (int i = 0; i < maxY; i++) {
                for (int j = 0; j < maxX; j++) {
                    sentinel[i][j] = false;
                }
            }

            return search(matrix, sentinel, x, y, maxX, maxY, target);
        }

        private boolean search(int[][] matrix, boolean[][] sentinel, int x, int y, int maxX, int maxY, int target) {

            // index is out of range
            if (x < 0 || y < 0 || x >= maxX || y >= maxY) {
                return false;
            }

            if (sentinel[y][x]) {
                return false;
            }
            sentinel[y][x] = true;

            int cur = matrix[y][x];
            // System.out.println(String.format("Searching matrix[%s][%s]=%s", x, y, cur));

            if (target == cur) {
                return true;
            } else if (target > cur) {

                return
                        // move right
                        search(matrix, sentinel, x + 1, y, maxX, maxY, target)

                                // move down
                                || search(matrix, sentinel, x, y + 1, maxX, maxY, target);
            } else {
                return
                        // move left
                        search(matrix, sentinel, x - 1, y, maxX, maxY, target)

                                // move up
                                || search(matrix, sentinel, x, y - 1, maxX, maxY, target);
            }
        }
    }
}
