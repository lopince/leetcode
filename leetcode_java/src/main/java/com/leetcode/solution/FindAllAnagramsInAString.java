package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {

//        String s = "op";
//        String p = "by";
//
//        Solution solution = new Solution();
//        System.out.println(solution.findAnagrams(s, p));
        System.out.println('a');
        System.out.println('y');
        System.out.println('y' - 'a');
    }

    private static class Solution {

        public List<Integer> findAnagrams(String s, String p) {

            List<Integer> res = new ArrayList<>();

            if (s == null || s.length() == 0) {
                return res;
            }

            if (p == null || p.length() == 0) {
                return res;
            }

//            if (p.length() == s.length()){
//                if (p.equals(s)){
//                    res.add(0);
//                }
//                return res;
//            }

            if (p.length() > s.length()) {
                return res;
            }

            int pLen = p.length();
            int sLen = s.length();

            int[] pCounter = count(p);

            for (int start = 0, end = pLen - 1; end < sLen; ) {

                System.out.println(String.format("[%s, %s]", start, end));

                if (end - start + 1 == pLen) {

                    int[] counter = count(s.substring(start, end + 1));
                    if (isAnagrams(pCounter, counter)) {
                        res.add(start);
                    }

                    if (end == sLen - 1) {
                        break;
                    }

                    start++;
                } else {
                    end++;
                }
            }


            return res;
        }

        private boolean isAnagrams(int[] counter1, int[] counter2) {

            int len = Math.min(counter1.length, counter2.length);
            for (int i = 0; i < len; i++) {
                if (counter1[i] != counter2[i]) {
                    return false;
                }
            }

            return true;
        }

        private int[] count(String s) {

            int[] counter = new int[26];
            char[] array = s.toCharArray();
            for (char c : array) {
                counter[c - 'a']++;
            }

            return counter;
        }
    }


}
