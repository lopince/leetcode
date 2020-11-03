package com.leetcode.solution;

public class CompareVersionNumbers {

    public static void main(String[] args) {
        String version1 = "1.1";
        String version2 = "1";

        Solution solution = new Solution();
        System.out.println(solution.compareVersion(version1, version2));
    }

    private static class Solution {

        public int compareVersion(String version1, String version2) {

            if (version1.equals(version2)) {
                return 0;
            }

            String[] v1Segments = version1.split("\\.");
            String[] v2Segments = version2.split("\\.");

            int len1 = v1Segments.length;
            int len2 = v2Segments.length;

            int i = 0;
            for (; i < len1 && i < len2; i++) {
                int i1 = Integer.parseInt(v1Segments[i]);
                int i2 = Integer.parseInt(v2Segments[i]);

                if (i1 < i2) {
                    return -1;
                } else if (i1 > i2) {
                    return 1;
                }
            }

            if (len1 == len2) {
                return 0;
            }

            int cur = i;
            while (cur < len1) {
                if (Integer.parseInt(v1Segments[cur++]) > 0){
                    return 1;
                }
            }

            cur = i;
            while (cur < len2) {
                if (Integer.parseInt(v2Segments[cur++]) > 0){
                    return -1;
                }
            }

            return 0;
        }
    }
}
