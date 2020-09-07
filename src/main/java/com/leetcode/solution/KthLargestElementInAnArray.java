package com.leetcode.solution;

public class KthLargestElementInAnArray {

    private static class Solution {
        public int findKthLargest(int[] nums, int k) {
            int size = nums.length;
            heapify(nums, size);

            while (k-- > 1) {

                swap(nums, 0, --size);
                heapify(nums, size);
            }

            return nums[0];
        }

        public void heapify(int[] nums, int size) {

            // size/2 is the first non-leaf node
            for (int i = size / 2; i >= 0; --i) {
                heapify(nums, i, size);
            }
        }


        // adjust nums[i, i+size] as heap
        public void heapify(int[] nums, int i, int size) {

            // left child for node_i
            int l = i * 2 + 1;

            // right child for node_i
            int r = i * 2 + 2;

            // top of the heap/max value
            int maxIndex = i;

            if (l < size && nums[l] > nums[maxIndex]) {
                maxIndex = l;
            }
            if (r < size && nums[r] > nums[maxIndex]) {
                maxIndex = r;
            }
            if (maxIndex != i) {
                swap(nums, i, maxIndex);

                // adjust the sub tree as head
                heapify(nums, maxIndex, size);
            }
        }

        public void swap(int[] array, int i, int j) {

            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
}
