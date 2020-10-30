package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class MedianofTwoSortedArrays {

    private static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int i = 0;
            int j = 0;

            List<Integer> list = new ArrayList<>();
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    list.add(nums1[i++]);
                } else {
                    list.add(nums2[j++]);
                }
            }

            while (i < nums1.length) {
                list.add(nums1[i++]);
            }
            while (j < nums2.length) {
                list.add(nums2[j++]);
            }

            int size = list.size();
            int mid = size / 2;
            return size % 2 == 0 ? (list.get(mid-1) + list.get(mid)) * 1.0 / 2 : list.get(mid);
        }
    }
}
