package com.leetcode.solution;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {

        String s = "A";

        Solution solution = new Solution();
        System.out.println(solution.titleToNumber(s));
    }

    private static class Solution {

        public int titleToNumber(String s) {

            if (s == null || s.length() == 0){
                return 0;
            }

            char[] array = s.toCharArray();

            int number = 0;
            int carry = 26;
            for (int i = array.length - 1; i >= 0; i--) {
                number += Math.pow(carry, array.length - 1 - i) * (array[i] - 'A' + 1);
            }

            return number;
        }
    }
}
