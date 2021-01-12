package com.leetcode.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
                if (j < values.length && values[j] != null) {
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

        List<Integer> ret = new ArrayList<>();

        TreeNode cur = this;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(cur);

        while (!queue.isEmpty()) {

            int count = queue.size();
            while (count-- > 0) {

                cur = queue.poll();

                if (cur != null) {

                    ret.add(cur.val);

                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else {

                    ret.add(null);
                }
            }
        }

        if (ret.size() > 1) {
            int index = ret.size() - 1;
            while (index >= 0 && ret.get(index) == null) {
                index--;
            }
            ret = ret.subList(0, index + 1);
        }

        return ret.toString();
    }

    public static void main(String[] args) {

        Integer[] seq = new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};

        TreeNode root = TreeNode.gen(seq);
        System.out.println(root);
    }
}
