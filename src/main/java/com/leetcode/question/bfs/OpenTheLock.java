package com.leetcode.question.bfs;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OpenTheLock {

    public static void main(String[] args) {

        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

//        String[] deadends = new String[]{"8888"};
//        String target = "0009";

        Solution solution = new Solution();
        System.out.println(solution.openLock2(deadends, target));
    }

    private static class Solution {

        public int openLock(String[] deadends, String target) {

            return openLock(
                    Stream.of(deadends)
                            .collect(Collectors.toList()),
                    target);
        }

        private int openLock(List<String> deadends, String target) {

            String cur = "0000";

            Queue<String> queue = new LinkedBlockingQueue<>();
            Set<String> sentinel = new HashSet<>();

            queue.offer(cur);
            sentinel.add(cur);

            int step = 0;

            while (!queue.isEmpty()) {

                int size = queue.size();
                for (int i = 0; i < size; i++) {

                    cur = queue.poll();
                    if (target.equals(cur)) {
                        return step;
                    }
                    if (deadends.contains(cur)) {
                        continue;
                    }

                    for (int j = 0; j < 4; j++) {

                        String temp = plus(cur, j);
                        if (!sentinel.contains(temp)) {
                            queue.offer(temp);
                            sentinel.add(temp);
                        }

                        temp = minus(cur, j);
                        if (!sentinel.contains(temp)) {
                            queue.offer(temp);
                            sentinel.add(temp);
                        }
                    }
                }

                step++;
            }

            return -1;
        }

        /**
         * 双向bfs
         */
        public int openLock2(String[] deadends, String target) {

            Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));

            Set<String> q1 = new HashSet<>();
            Set<String> q2 = new HashSet<>();
            Set<String> sentinel = new HashSet<>();

            int step = 0;
            q1.add("0000");
            q2.add(target);

            while (!q1.isEmpty() && !q2.isEmpty()) {

                if (q1.size() > q2.size()) {
                    // 交换 q1 和 q2
                    swap(q1, q2);
                }

                Set<String> tempSet = new HashSet<>();

                for (String cur : q1) {

                    if (deadendSet.contains(cur)) {
                        continue;
                    }
                    if (q2.contains(cur)) {
                        return step;
                    }
                    sentinel.add(cur);

                    for (int j = 0; j < 4; j++) {

                        String temp = plus(cur, j);
                        if (!sentinel.contains(temp)) {
                            tempSet.add(temp);
                        }

                        temp = minus(cur, j);
                        if (!sentinel.contains(temp)) {
                            tempSet.add(temp);
                        }
                    }
                }

                step++;
                q1 = q2;
                q2 = tempSet;
            }

            return -1;
        }

        private String plus(String cur, int index) {

            int val = Integer.parseInt(cur.substring(index, index + 1));
            if (val == 9) {
                val = 0;
            } else {
                val++;
            }

            return replace(cur, index, val);
        }

        private String minus(String cur, Integer index) {

            int val = Integer.parseInt(cur.substring(index, index + 1));
            if (val == 0) {
                val = 9;
            } else {
                val--;
            }

            return replace(cur, index, val);
        }

        private String replace(String cur, int index, int val) {

            StringBuilder sb = new StringBuilder(cur);
            sb.replace(index, index + 1, String.valueOf(val));

            return sb.toString();
        }

        private <T> void swap(Set<T> set1, Set<T> set2){

            Set<T> temp = set1;
            set1 = set2;
            set2 = temp;
        }
    }
}
