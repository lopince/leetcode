package com.leetcode.solution;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        Solution solution = new Solution();
        System.out.println("res: " + solution.minWindow(s, t));
    }

    private static class Solution {

        public String minWindow(String s, String t) {

            if (s == null || s.length() == 0) {
                return "";
            }
            if (t == null || t.length() == 0) {
                return "";
            }
            if (t.length() > s.length()) {
                return "";
            }
            if (t.equals(s)) {
                return t;
            }

            HashMap<Character, Integer> cnt = new HashMap<>();
            HashMap<Character, Integer> cur = new HashMap<>();
            for (char c : t.toCharArray()) {
                if (cnt.containsKey(c)) {
                    cnt.put(c, cnt.get(c) + 1);
                } else {
                    cnt.put(c, 1);
                }

                cur.put(c, 0);
            }

            int i = 0;
            int j = 0;
            int len = s.length();
            String res = "";
            while (i < len && j < len) {

                while (!contains(cnt, cur) && i < len) {
                    incr(cur, s.charAt(i++));
                }
                boolean contains = contains(cnt, cur);

                while (contains(cnt, cur) && j < len) {
                    minus(cur, s.charAt(j++));
                }

                // now the min window is [j-1, i] which is end of i
                if (("".equals(res) || res.length() > (i - j + 1)) && contains) {
                    res = s.substring(j - 1, i);
                }
            }

            return res;
        }

        private boolean contains(HashMap<Character, Integer> cnt, HashMap<Character, Integer> cur) {
            for (char c : cnt.keySet()) {
                if (cnt.get(c) > cur.get(c)) {
                    return false;
                }
            }

            return true;
        }

        private void incr(HashMap<Character, Integer> map, char c) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
        }

        private void minus(HashMap<Character, Integer> map, char c) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }
    }
}
