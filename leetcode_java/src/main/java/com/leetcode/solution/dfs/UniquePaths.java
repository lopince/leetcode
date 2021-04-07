package com.leetcode.solution.dfs;

public class UniquePaths {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(2, 2));
    }

    private static class Solution {

        public int uniquePaths(int m, int n) {

            return uniquePaths(1, 1, m, n);
        }

        public int uniquePaths(int curM, int curN, int destM, int destN) {

            System.out.println(String.format("curM: %s, curN: %s", curM, curN));

            if (curM == destM && curN == destN) {
                return 1;
            }

            if (curM > destM || curN > destN) {
                return 0;
            }

            int counter = 0;
            counter += uniquePaths(curM + 1, curN, destM, destN);
            counter += uniquePaths(curM, curN + 1, destM, destN);

            return counter;
        }
    }
}
