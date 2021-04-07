package com.leetcode.solution;

public class Sqrtx {

    public static void main(String[] args) {

        int x = 2147395599;

        Solution solution = new Solution();
        System.out.println(solution.mySqrt(x));
    }

    private static class Solution {

        public int mySqrt(int x) {

            long l = 0;
            long r = x;
            long ans = -1;

            while (l <= r) {

                System.out.printf("l: %s, r: %s, ans: %s\n", l, r, ans);

                long mid = (l + r) / 2;

                if (mid * mid <= x) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            return (int) ans;
        }
    }
}
