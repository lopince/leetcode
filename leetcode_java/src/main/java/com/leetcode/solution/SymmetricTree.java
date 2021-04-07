package com.leetcode.solution;

import com.leetcode.bean.TreeNode;

public class SymmetricTree {

    public static void main(String[] args) {

//        TreeNode root = TreeNode.gen(1, 2, 2, 3, 4, 4, 3);
        TreeNode root = TreeNode.gen(1, 2, 2, null, 3, null, 3);

        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(root));
    }

    private static class Solution {

        public boolean isSymmetric(TreeNode root) {

            return isSymmetric(root, root);
        }

        private boolean isSymmetric(TreeNode p, TreeNode q) {

            if (p == null && q == null) {
                return true;
            }

            if (p == null || q == null) {
                return false;
            }

            return p.val == q.val
                    && isSymmetric(p.right, q.left)
                    && isSymmetric(p.left, q.right);
        }
    }
}
