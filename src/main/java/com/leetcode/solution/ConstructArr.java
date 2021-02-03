package com.leetcode.solution;

import java.util.Arrays;

public class ConstructArr {

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3, 4, 5};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.constructArr(a)));
    }

    private static class Solution {

        public int[] constructArr(int[] a) {

            if (a == null || a.length == 0) {
                return a;
            }

            int[] l = new int[a.length];
            l[0] = 1;
            int[] r = new int[a.length];
            r[a.length - 1] = 1;

            for (int i = 1; i < a.length; i++) {
                l[i] = l[i - 1] * a[i - 1];
            }

            for (int i = a.length - 2; i >= 0; i--) {
                r[i] = r[i + 1] * a[i + 1];
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = l[i] * r[i];
            }

            return a;
        }
    }
}
