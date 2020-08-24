package com.leetcode.solution.dp;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {

        String s = "catsandog";
        List<String> wordDict = Lists.newArrayList("cats", "dog", "sand", "and", "cat");

        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, wordDict));
    }

    private static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {

            // dp[i] s.substring(0, i) can be segmented into a space-separated sequence
            boolean[] dp = new boolean[s.length() + 1];
            Arrays.fill(dp, false);
            dp[0] = true;

            int len = s.length();
            for (int i = 1; i <= len; i++) {

                for (String word : wordDict) {

                    int wLen = word.length();
                    if (i >= wLen
                            && s.substring(i - wLen, i).equals(word)
                            && dp[i - wLen]) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[len];
        }
    }

}
