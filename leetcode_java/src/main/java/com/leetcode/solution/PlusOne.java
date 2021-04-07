package com.leetcode.solution;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {

        int[] digits = new int[]{9,9,9};

        Solution solution = new Solution();
        System.out.println(
                Arrays.toString(
                        solution.plusOne(digits)));
    }

    private static class Solution {


        public int[] plusOne(int[] digits) {

            int[] res = new int[digits.length + 1];

            digits[digits.length - 1]++;

            int carry = 0;
            for (int i = digits.length - 1; i >= 0; i--) {

                res[i + 1] = digits[i] + carry;
                carry = res[i + 1] / 10;
                res[i + 1] %= 10;
            }
            res[0] = carry;

            return res[0] == 0 ? Arrays.copyOfRange(res, 1, res.length) : res;
        }
    }

}
