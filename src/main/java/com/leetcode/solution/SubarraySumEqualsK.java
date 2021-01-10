package com.leetcode.solution;


import java.util.HashMap;

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        int[] nums = new int[]{1, -1, 0};
        int k = 0;

        Solution solution = new Solution();
        System.out.println(solution.subarraySum(nums, k));
    }

    private static class Solution {

        public int subarraySum(int[] nums, int k) {

            if (nums == null || nums.length == 0) {
                return 0;
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);

            int sum = 0;
            int ret = 0;
            for (int num : nums) {

                sum += num;

                // k=3
                // map.get(i)=9, [i,...,j]=3, (j,...,0]=6
                if (map.containsKey(sum - k)) {
                    ret += map.get(sum - k);
                }

                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            map.forEach((u, v) -> System.out.println(u + ": " + v));

            return ret;
        }
    }
}
