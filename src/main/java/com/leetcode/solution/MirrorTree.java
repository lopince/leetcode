package com.leetcode.solution;

import com.leetcode.bean.TreeNode;

public class MirrorTree {

    public static void main(String[] args) {

        TreeNode root = TreeNode.gen(4, 2, 7, 1, 3, 6, 9);

        Solution solution = new Solution();
        System.out.println(solution.mirrorTree(root));
    }

    private static class Solution {

        public TreeNode mirrorTree(TreeNode root) {

            if (root == null){
                return null;
            }

            TreeNode l = root.left;
            TreeNode r = root.right;

            root.left = mirrorTree(r);
            root.right = mirrorTree(l);

            return root;
        }
    }
}
