package com.leetcode.solution;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) throws Exception {

        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3, 3};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k)));
    }

    private static class Solution {

        public int[] topKFrequent(int[] nums, int k) {

            if (nums == null || nums.length == 0 || k < 1) {
                return new int[]{};
            }

            HashMap<Integer, Integer> counter = new HashMap<>();

            for (int num : nums) {
                if (counter.containsKey(num)) {
                    counter.put(num, counter.get(num) + 1);
                } else {
                    counter.put(num, 1);
                }
            }

            // using priority queue to simulate min heap
            // int[0]: num, int[1]: times
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {

                int num = entry.getKey();
                int count = entry.getValue();

                if (queue.size() == k) {
                    if (queue.peek()[1] < count) {
                        queue.poll();
                        queue.offer(new int[]{num, count});
                    }
                } else {
                    queue.offer(new int[]{num, count});
                }
            }

            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = queue.poll()[0];
            }

            return ans;
        }
    }
}
