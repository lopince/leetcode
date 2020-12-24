package com.leetcode.solution;

import com.leetcode.bean.TreeNode;

import java.util.HashMap;

public class PathSum3 {

    public static void main(String[] args) {

//        TreeNode root = TreeNode.gen(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);

        TreeNode root = TreeNode.gen(1, -2, -3);

        Solution solution = new Solution();
        System.out.println(solution.pathSum(root, -1));
    }

    private static class Solution {

        int count = 0;

        public int pathSum(TreeNode root, int targetSum) {

            backtrace(root, targetSum, 0, new HashMap<>());
            return count;
        }

        private void backtrace(TreeNode cur, int targetSum, int prefixSum, HashMap<Integer, Integer> prefixSumCounter) {

            if (cur != null) {

                prefixSum += cur.val;

                if (targetSum == prefixSum) {
                    count++;

                }

                if (prefixSumCounter.containsKey(prefixSum - targetSum)) {
                    count += prefixSumCounter.get(prefixSum - targetSum);
                }

                if (prefixSumCounter.containsKey(prefixSum)) {
                    prefixSumCounter.put(prefixSum, prefixSumCounter.get(prefixSum) + 1);
                } else {
                    prefixSumCounter.put(prefixSum, 1);
                }

                backtrace(cur.left, targetSum, prefixSum , new HashMap<>(prefixSumCounter));
                backtrace(cur.right, targetSum, prefixSum, new HashMap<>(prefixSumCounter));
            }
        }
    }
}
