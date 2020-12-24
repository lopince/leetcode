package com.leetcode.bean;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode gen(Integer... values) {

        if (values.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // [10, 5, -3, 3, 2, null, 11, 3, -2, null, 1]
        for (int i = 1; i < values.length; i += 2) {

            TreeNode cur = queue.poll();

            if (cur != null) {
                int j = i;

                TreeNode l;
                if (values[j] != null) {
                    l = new TreeNode(values[j]);
                } else {
                    l = null;
                }

                TreeNode r;
                j++;
                if ( j < values.length && values[j] != null) {
                    r = new TreeNode(values[j]);
                } else {
                    r = null;
                }

                cur.left = l;
                cur.right = r;

                queue.offer(l);
                queue.offer(r);
            }
        }

        return root;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
