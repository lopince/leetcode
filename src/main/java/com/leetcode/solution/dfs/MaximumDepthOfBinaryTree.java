package com.leetcode.solution.dfs;

import com.leetcode.bean.TreeNode;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = TreeNode.gen(1, null, 2);

        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root));
    }

    private static class Solution {

        int maxDepth = 0;

        public int maxDepth(TreeNode root) {
            dfs(root, 1);
            return maxDepth;
        }

        private void dfs(TreeNode cur, int depth) {

            if (cur == null) {
                depth--;
                if (depth > maxDepth && depth > 0) {
                    maxDepth = depth;
                }
            } else {
                dfs(cur.left, depth + 1);
                dfs(cur.right, depth + 1);
            }
        }
    }
}
