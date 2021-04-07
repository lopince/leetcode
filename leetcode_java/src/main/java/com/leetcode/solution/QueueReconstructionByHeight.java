package com.leetcode.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;

public class QueueReconstructionByHeight {

    public static void main(String[] args) {

        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        Solution solution = new Solution();
        Stream.of(solution.reconstructQueue(people))
                .map(Arrays::toString)
                .forEach(System.out::println);
    }

    private static class Solution {

        public int[][] reconstructQueue(int[][] people) {

            Arrays.parallelSort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

            LinkedList<int[]> list = new LinkedList<>();
            for (int[] p : people) {
                list.add(p[1], p);
            }

            return list.toArray(new int[list.size()][2]);
        }
    }
}
