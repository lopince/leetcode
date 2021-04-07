package com.leetcode.solution.bfs;

import com.google.common.collect.Lists;
import com.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

        TreeNode node_3 = new TreeNode(3);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_9 = new TreeNode(9);
        TreeNode node_15 = new TreeNode(15);
        TreeNode node_20 = new TreeNode(20);

        /*
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */
        node_3.left = node_9;
        node_3.right = node_20;
        node_20.left = node_15;
        node_20.right = node_7;

        Solution solution = new Solution();
        List<List<Integer>> res = solution.levelOrder(node_3);
        res.forEach(System.out::println);
    }

    private static class Solution {

        public List<List<Integer>> levelOrder(TreeNode root) {

            if (root == null) {
                return new ArrayList<>();
            }

            TreeNode cur = root;

            Queue<TreeNode> queue = new LinkedBlockingQueue<>();
            queue.offer(cur);

            List<List<Integer>> res = new ArrayList<>();

            while (!queue.isEmpty()) {

                List<Integer> curLevel = new ArrayList<>();

                int counter = queue.size();
                while (counter-- > 0) {

                    cur = queue.poll();

                    curLevel.add(cur.val);

                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }

                res.add(curLevel);
            }

            return res;
        }
    }
}
