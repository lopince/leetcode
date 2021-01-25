package com.leetcode.shopee;

public class PalindromeNumber {

    public static void main(String[] args) {

        int x = 121;

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(x));
    }

    private static class Solution {
        public boolean isPalindrome(int x) {

            if (0 <= x && x <= 9) {
                return true;
            }

            char[] array = String.valueOf(x).toCharArray();
            for (int i = 0, j = array.length - 1; i <= j; i++, j--) {
                if (array[i] != array[j]){
                    return false;
                }
            }

            return true;
        }
    }
}
