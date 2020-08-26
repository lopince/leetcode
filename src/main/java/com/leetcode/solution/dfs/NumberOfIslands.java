package com.leetcode.solution.dfs;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class NumberOfIslands {

    private static class Solution {

        public int numIslandsUsingDFS(char[][] grid) {

            if (grid == null || grid.length == 0){
                return 0;
            }

            int xMax = grid[0].length;
            int yMax = grid.length;

            int counter = 0;
            for (int x = 0; x < xMax; x++) {
                for (int y = 0; y < yMax; y++) {

                    if (grid[y][x] == '1') {
                        counter++;
                        dfs(grid, x, y);
                    }
                }
            }

            return counter;
        }

        private void dfs(char[][] grid, int x, int y) {

            int xMax = grid[0].length;
            int yMax = grid.length;

            if (grid[y][x] == '1') {

                grid[y][x] = '0';

                if (x + 1 < xMax) {
                    dfs(grid, x + 1, y);
                }
                if (y + 1 < yMax) {
                    dfs(grid, x, y + 1);
                }
                if (x - 1 >= 0) {
                    dfs(grid, x - 1, y);
                }
                if (y - 1 >= 0) {
                    dfs(grid, x, y - 1);
                }
            }
        }

        public int numIslandsUsingBFS(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int xMax = grid[0].length;
            int yMax = grid.length;

            int counter = 0;
            for (int x = 0; x < xMax; x++) {
                for (int y = 0; y < yMax; y++) {

                    if (grid[y][x] == '1') {
                        counter++;
                        bfs(grid, x, y);
                    }
                }
            }

            return counter;
        }

        private void bfs(char[][] grid, int x, int y) {

            int xMax = grid[0].length;
            int yMax = grid.length;

            Queue<Integer[]> queue = new LinkedBlockingQueue<>();
            queue.offer(new Integer[]{x, y});

            Set<String> sentinel = new HashSet<>();
            sentinel.add(toString(x, y));

            while (!queue.isEmpty()) {

                int counter = queue.size();
                while (counter-- > 0) {

                    Integer[] point = queue.poll();
                    Integer curX = point[0];
                    Integer curY = point[1];

                    if (curY + 1 < yMax
                            && grid[curY + 1][curX] == '1'
                            && !sentinel.contains(toString(curX, curY + 1))) {

                        grid[curY + 1][curX] = '0';
                        sentinel.add(toString(curX, curY + 1));
                        queue.offer(new Integer[]{curX, curY + 1});
                    }
                    if (curX + 1 < xMax
                            && grid[curY][curX + 1] == '1'
                            && !sentinel.contains(toString(curX + 1, curY))) {

                        grid[curY][curX + 1] = '0';
                        sentinel.add(toString(curX + 1, curY));
                        queue.offer(new Integer[]{curX + 1, curY});
                    }
                    if (curY - 1 >= 0
                            && grid[curY - 1][curX] == '1'
                            && !sentinel.contains(toString(curX, curY - 1))) {

                        grid[curY - 1][curX] = '0';
                        sentinel.add(toString(curX, curY - 1));
                        queue.offer(new Integer[]{curX, curY - 1});
                    }
                    if (curX - 1 >= 0
                            && grid[curY][curX - 1] == '1'
                            && !sentinel.contains(toString(curX - 1, curY))) {

                        grid[curY][curX - 1] = '0';
                        sentinel.add(toString(curX - 1, curY));
                        queue.offer(new Integer[]{curX - 1, curY});
                    }
                }
            }
        }

        private static String toString(int x, int y) {

            return x + "," + y;
        }
    }
}
