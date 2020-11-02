package com.leetcode.solution.dfs;

import com.leetcode.bean.TreeNode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.function.Consumer;

public class InvertBinaryTree {

    public static void main(String[] args) {

        TreeNode node_4 = new TreeNode(4);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_9 = new TreeNode(9);

        node_4.left = node_2;
        node_4.right = node_7;

        node_2.left = node_1;
        node_2.right = node_3;
        node_7.left = node_6;
        node_7.right = node_9;

        dfs(node_4);

        Solution solution = new Solution();
        TreeNode invertedRoot = solution.invertTree(node_4);
        System.out.println();

        dfs(invertedRoot);
    }

    private static class Solution {

        public TreeNode invertTree(TreeNode root) {

            if (root != null) {

                TreeNode l = invertTree(root.right);
                TreeNode r = invertTree(root.left);

                root.left = l;
                root.right = r;

                return root;
            }

            return null;
        }
    }

    private static void dfs(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        HashSet<TreeNode> sentinel = new HashSet<>();

        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode cur = queue.poll();
                if (cur != null) {

                    System.out.print(cur.val + " ");

                    if (cur.left != null && !sentinel.contains(cur.left)) {
                        queue.offer(cur.left);
                        sentinel.add(cur.left);
                    }
                    if (cur.right != null && !sentinel.contains(cur.right)) {
                        queue.offer(cur.right);
                        sentinel.add(cur.right);
                    }
                }
            }

            System.out.println();
        }
    }
}
