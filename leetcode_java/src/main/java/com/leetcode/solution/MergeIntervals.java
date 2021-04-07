package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    private static class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length < 2) {
                return intervals;
            }

            // 通过左端点，进行排序
            Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));

            List<int[]> mergedIntervals = new ArrayList<>();

            int[] curInterval = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                int[] interval = intervals[i];
                if (canMerge(curInterval, interval)) {
                    curInterval = merge(interval, curInterval);
                } else {
                    mergedIntervals.add(curInterval);
                    curInterval = interval;
                }
            }
            mergedIntervals.add(curInterval);

            return mergedIntervals.toArray(new int[0][]);
        }

        private int[] merge(int[] intervals1, int[] intervals2) {

            return new int[]{
                    Math.min(intervals1[0], intervals2[0]),
                    Math.max(intervals1[1], intervals2[1])};
        }

        private boolean canMerge(int[] intervals1, int[] intervals2) {

            return Math.max(intervals1[0], intervals2[0])
                    <= Math.min(intervals1[1], intervals2[1]);
        }
    }

}
