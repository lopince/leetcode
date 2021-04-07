package com.leetcode.solution.dp;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.countBits(5)));
    }

    private static class Solution {

        public int[] countBits(int num) {

            int[] bits = new int[num + 1];

            int binary = 1;
            int i = 0;

            while (binary <= num) {

                // binary = 4
                // 4, 5, 6, 7 ==> 100, 101, 110, 111
                // i ==> 0, 1, 2, 3
                // 当前数字二进制1的数目，等于减去最高有效位，对应数字二进制1的数目+1

                while (i < binary && i + binary <= num) {
                    bits[i + binary] = bits[i] + 1;
                    i++;
                }

                i = 0;
                binary *= 2;
            }


            return bits;
        }
    }


}
