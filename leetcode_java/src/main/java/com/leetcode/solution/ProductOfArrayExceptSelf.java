package com.leetcode.solution;

public class ProductOfArrayExceptSelf {

    private static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;

            int[] outputs = new int[len];
            int[] l = new int[len];
            int[] r = new int[len];

            l[0] = 1;
            for (int i = 1; i < len; i++) {
                l[i] = l[i - 1] * nums[i - 1];
            }
            r[len - 1] = 1;
            for (int i = len - 2; i >= 0; i--) {
                r[i] = r[i + 1] * nums[i + 1];
            }

            outputs[0] = r[0];
            outputs[len - 1] = l[len - 1];
            for (int i = 1; i < len - 1; i++) {
                outputs[i] = l[i] * r[i];
            }

//            System.out.println("l: " + Arrays.toString(l));
//            System.out.println("r: " + Arrays.toString(r));

            return outputs;
        }
    }
}
