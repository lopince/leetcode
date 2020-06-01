package com.leetcode.question;

public class ReverseInteger {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int reverse(int x) {

            int res = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;

                if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) return 0;
                if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10)) return 0;

                res = res * 10 + pop;
            }

            return res;
        }
    }
}
