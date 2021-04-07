package com.leetcode.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {

        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;

        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums, k));
    }

    private static class Solution {
        public int findKthLargest(int[] nums, int k) {

            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));

            for (int num : nums) {

                if (queue.size() < k) {
                    queue.offer(num);
                }else {
                    if (num > queue.peek()){
                        queue.poll();
                        queue.add(num);
                    }
                }
            }

            return queue.poll();
        }
    }
}
