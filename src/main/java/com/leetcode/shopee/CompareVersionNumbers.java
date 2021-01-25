package com.leetcode.shopee;

public class CompareVersionNumbers {

    public static void main(String[] args) {

        String version1 = "0.1";
        String version2 = "1.1";

        Solution solution = new Solution();
        System.out.println(solution.compareVersion(version1, version2));
    }

    private static class Solution {

        public int compareVersion(String version1, String version2) {

            if (version1.equals(version2)) {
                return 0;
            }

            String[] seg1 = version1.split("\\.");
            String[] seg2 = version2.split("\\.");

            int i = 0;
            int j = 0;
            while (i < seg1.length && j < seg2.length) {

                int v1 = Integer.parseInt(seg1[i]);
                int v2 = Integer.parseInt(seg2[j]);

                if (v1 > v2) {
                    return 1;
                } else if (v1 < v2) {
                    return -1;
                }

                i++;
                j++;
            }

            while (i < seg1.length) {
                if (Integer.parseInt(seg1[i++]) > 0){
                    return 1;
                }
            }

            while (j < seg2.length){
                if (Integer.parseInt(seg2[j++]) > 0){
                    return -1;
                }
            }

            return 0;
        }
    }
}
