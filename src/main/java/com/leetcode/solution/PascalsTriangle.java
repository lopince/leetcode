package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {

        int numRows = 5;

        Solution solution = new Solution();
        List<List<Integer>> ret = solution.generate(numRows);
        ret.forEach(System.out::println);
    }

    private static class Solution {

        public List<List<Integer>> generate(int numRows) {

            List<List<Integer>> ret = new ArrayList<>();

            if (numRows == 0) {
                return ret;
            }

            List<Integer> pre = Collections.singletonList(1);
            ret.add(pre);

            for (int i = 2; i <= numRows; i++) {

                List<Integer> cur = new ArrayList<>();
                for (int j = 0; j < i; j++) {

                    if (j == 0 || j == i - 1) {
                        cur.add(1);
                    } else {
                        cur.add(pre.get(j - 1) + pre.get(j));
                    }
                }

                ret.add(cur);

                pre = cur;
            }

            return ret;
        }
    }
}
