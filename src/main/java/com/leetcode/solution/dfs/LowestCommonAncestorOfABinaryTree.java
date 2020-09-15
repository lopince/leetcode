package com.leetcode.solution.dfs;

import com.leetcode.bean.TreeNode;

public class LowestCommonAncestorOfABinaryTree {

    private static class Solution {
        private TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            dfs(root, p, q);
            return ans;
        }

        private boolean dfs(TreeNode cur, TreeNode p, TreeNode q) {

            if (cur == null) {
                return false;
            }

            boolean lson = dfs(cur.left, p, q);
            boolean rson = dfs(cur.right, p, q);

            if ((lson && rson) || ((equals(cur, p) || equals(cur, q)) && (lson || rson))) {
                ans = cur;
            }

            return lson || rson || (equals(cur, p) || equals(cur, q));
        }

        private boolean equals(TreeNode a, TreeNode b) {
            return a.val == b.val;
        }
    }
}
