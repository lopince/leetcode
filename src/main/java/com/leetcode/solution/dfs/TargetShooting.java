package com.leetcode.solution.dfs;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TargetShooting {

    /**
     * 打靶问题:一个射击运动员打靶，靶一共有10环，连开10枪打中90环的可能性有多少？
     */

    public static void main(String[] args) {

        Solution solution = new Solution();

        List<List<Integer>> res = solution.targetShooting();
        System.out.println(res.size());
        res.forEach(System.out::println);
    }

    private static class Solution {

        List<List<Integer>> res = new ArrayList<>();

        private List<List<Integer>> targetShooting() {

            dfs(Lists.newLinkedList(), 0, 0);

            return res;
        }

        private void dfs(LinkedList<Integer> record, int times, int curScore) {

            if (times <= 10) {

                if (curScore == 90) {
                    res.add(Lists.newLinkedList(record));

                } else if (curScore < 90) {

                    for (int i = 0; i <= 10; i++) {

                        record.addLast(i);

                        int minScore = times * 10;
                        if (curScore + i >= minScore) {
                            dfs(record, times + 1, curScore + i);
                        }
                        // else curScore < minScore, pruning

                        record.removeLast();
                    }
                }
                // else curScore > 90, pruning
            }
        }
    }
}
