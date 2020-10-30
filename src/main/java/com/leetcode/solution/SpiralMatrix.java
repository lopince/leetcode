package com.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralMatrix {

    private static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();

            if (matrix == null || matrix.length == 0) {
                return res;
            }

            int x0 = 0;
            int xn = matrix[0].length - 1;
            int y0 = 0;
            int yn = matrix.length - 1;

            Set<Integer> visited = new HashSet<>();
            while (x0 <= xn && y0 <= yn) {

                int x = x0;
                int y = y0;
                for (; x <= xn; x++) {
                    int cur = matrix[y][x];
                    if (!visited.contains(cur)) {
                        res.add(matrix[y][x]);
                        visited.add(cur);
                    }
                }
                x--;

                for (; y <= yn; y++) {
                    int cur = matrix[y][x];
                    if (!visited.contains(cur)) {
                        res.add(matrix[y][x]);
                        visited.add(cur);
                    }
                }
                y--;

                for (; x >= x0; x--) {
                    int cur = matrix[y][x];
                    if (!visited.contains(cur)) {
                        res.add(matrix[y][x]);
                        visited.add(cur);
                    }
                }
                x++;

                for (; y >= y0; y--) {
                    int cur = matrix[y][x];
                    if (!visited.contains(cur)) {
                        res.add(matrix[y][x]);
                        visited.add(cur);
                    }
                }

                x0++;
                y0++;
                xn--;
                yn--;
            }

            return res;
        }
    }
}
