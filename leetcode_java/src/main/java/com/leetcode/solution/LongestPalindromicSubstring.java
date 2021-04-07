package com.leetcode.solution;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        String s = "babad";

        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(s));
    }

    private static class Solution {

        public String longestPalindrome(String s) {

            if (s == null || s.length() < 2) {
                return s;
            }

            boolean[][] dp = new boolean[s.length()][s.length()];

            int maxLen = 0;
            int maxI = -1;
            int maxJ = -1;

            for (int step = 0; step < s.length(); step++) {
                for (int i = 0; i + step < s.length(); i++) {

                    int j = i + step;

                    if (step == 0) {
                        dp[i][j] = true;

                    } else if (step == 1) {
                        dp[i][j] = (s.charAt(i) == s.charAt(j));

                    } else {
                        dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                    }

                    if (dp[i][j]){

                        int len = j - i + 1;
                        if (maxLen < len){
                            maxLen = len;
                            maxI = i;
                            maxJ = j;
                        }
                    }
                }
            }

            return maxLen > 0 ? s.substring(maxI, maxJ + 1) : null;
        }
    }
}
