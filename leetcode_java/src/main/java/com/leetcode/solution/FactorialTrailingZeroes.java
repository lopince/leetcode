package com.leetcode.solution;

public class FactorialTrailingZeroes {

    public static void main(String[] args) {

        int n = 3;

        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(n));
    }

    private static class Solution {

        public int trailingZeroes(int n) {

            int ans = 0;
            while (n > 0) {
                ans += n / 5;
                n = n / 5;
            }

            return ans;
        }
    }
}
