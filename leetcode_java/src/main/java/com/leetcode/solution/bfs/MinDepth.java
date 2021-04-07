package com.leetcode.solution.bfs;

import com.leetcode.bean.TreeNode;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class MinDepth {

    public static void main(String[] args) {

        TreeNode node_3 = new TreeNode(3);
        TreeNode node_9 = new TreeNode(9);
        TreeNode node_11 = new TreeNode(11);
        TreeNode node_20 = new TreeNode(20);
        TreeNode node_15 = new TreeNode(15);
        TreeNode node_7 = new TreeNode(7);

        node_3.left = node_9;
        node_3.right = node_20;
        node_9.left = node_11;
        node_20.left = node_15;
        node_20.right = node_7;

        Solution solution = new Solution();
        System.out.println(solution.minDepth(node_3));
    }

    private static class Solution {

        public int minDepth(TreeNode root) {

            if (root == null) {
                return 0;
            }

            Queue<TreeNode> queue = new LinkedBlockingQueue<>();
            Set<TreeNode> sentinel = new HashSet<>();

            queue.offer(root);
            sentinel.add(root);
            int step = 1;

            while (!queue.isEmpty()) {

                int size = queue.size();
                for (int i = 0; i < size; i++) {

                    TreeNode cur = queue.poll();
                    if (cur.left == null && cur.right == null) {
                        return step;
                    }

                    if (cur.left != null && !sentinel.contains(cur.left)) {
                        queue.offer(cur.left);
                        sentinel.add(cur.left);
                    }
                    if (cur.right != null && !sentinel.contains(cur.right)) {
                        queue.offer(cur.right);
                        sentinel.add(cur.right);
                    }
                }

                step++;
            }

            return step;
        }
    }
}
