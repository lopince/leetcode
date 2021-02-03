package com.leetcode.solution;

public class ReversePairs {

    public static void main(String[] args) {

        int[] nums = new int[]{233, 2000000001, 234, 2000000006, 235, 2000000003, 236, 2000000007, 237, 2000000002, 2000000005, 233, 233, 233, 233, 233, 2000000004};

        Solution solution = new Solution();
        System.out.println(solution.reversePairs(nums));
    }

    private static class Solution {

        public int reversePairs(int[] nums) {

            return reversePairs(nums, 0, nums.length - 1, new int[nums.length]);
        }

        private int reversePairs(int[] nums, int left, int right, int[] temp) {

            int count = 0;

            if (left < right) {

                int mid = (left + right) / 2;
                count += reversePairs(nums, left, mid, temp);
                count += reversePairs(nums, mid + 1, right, temp);
                count += merge(nums, left, mid, right, temp);
            }

            return count;
        }

        private int merge(int[] nums, int left, int mid, int right, int[] temp) {

            int count = 0;

            int i = left;
            int j = mid + 1;
            int k = 0;

            while (i <= mid && j <= right) {

                if (nums[j] < nums[i]) {

                    temp[k++] = nums[j++];

                    count += mid - i + 1;

                } else {
                    temp[k++] = nums[i++];
                }
            }

            while (i <= mid) {
                temp[k++] = nums[i++];
            }

            while (j <= right) {
                temp[k++] = nums[j++];
            }

            k = 0;
            while (left <= right) {
                nums[left++] = temp[k++];
            }

            return count;
        }

    }
}
