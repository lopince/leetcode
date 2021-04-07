package com.leetcode.solution;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        String s = "abcabcbb";

        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

    private static class Solution {

        public int lengthOfLongestSubstring(String s) {

            if (s == null || s.length() == 0){
                return 0;
            }

            int i = 0;
            int j = 0;
            int ans = 0;
            HashSet<Character> set = new HashSet<>();
            while (i < s.length() && j < s.length()){

                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i );

                }else {
                    set.remove(s.charAt(i++));
                }
            }

            return ans;
        }
    }
}
