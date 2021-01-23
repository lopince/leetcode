package com.leetcode.shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {

        int[] nums = new int[]{5, 2, 6, 1};

        Solution solution = new Solution();
        System.out.println(solution.countSmaller(nums));
        System.out.println("Sorted: " + Arrays.toString(nums));
    }

    private static class Solution {

        public List<Integer> countSmaller(int[] nums) {

            List<Integer> list = new ArrayList<>();
            List<Integer> res = new ArrayList<>();

            for (int i = nums.length - 1; i >= 0; i--) {

                int index = search(list, nums[i]);
                res.add(index);
                list.add(index, nums[i]);
            }
            System.out.println(list);

            Collections.reverse(res);
            return res;
        }

        private int search(List<Integer> list, int target) {

            int l = 0;
            int r = list.size();

            while (l < r) {
                int mid = (l + r) / 2;
                if (list.get(mid) > target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            return l;
        }
    }
}
