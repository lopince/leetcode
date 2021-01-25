package com.leetcode.shopee;

public class NextGreaterElementIII {

    public static void main(String[] args) {

        int n = 12388123;

        Solution solution = new Solution();
        System.out.println(solution.nextGreaterElement(n));
    }

    private static class Solution {

        public int nextGreaterElement(int n) {

            if (n < 12) {
                return -1;
            }

            char[] array = String.valueOf(n).toCharArray();
            int len = array.length;
            int i = len - 1;

            // find the first asc element
            while (i >= 1) {
                if (array[i] > array[i - 1]) {
                    break;
                }
                i--;
            }

            if (i != 0) {

                // find the first element greater than target
                int target = i - 1;
                while (i < len) {
                    if (array[target] > array[i]) {
                        break;
                    }
                    i++;
                }


                if (i <= len) {

                    // swap
                    i--;
                    char temp = array[target];
                    array[target] = array[i];
                    array[i] = temp;

                    // reverse
                    i = target + 1;
                    for (int j = len - 1; i < j; i++, j--) {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }

            if (Long.parseLong(String.valueOf(array)) > Integer.MAX_VALUE){
                return -1;
            }

            int cur = Integer.parseInt(String.valueOf(array));
            return n == cur ? -1 : cur;
        }
    }
}
