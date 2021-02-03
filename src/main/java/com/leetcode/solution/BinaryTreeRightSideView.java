package com.leetcode.solution;

import com.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {

        TreeNode root = TreeNode.gen(1, 2, 3, null, 5, null, 4);

        Solution solution = new Solution();
        System.out.println(solution.rightSideView(root));
    }

    private static class Solution {

        public List<Integer> rightSideView(TreeNode root) {

            List<Integer> ans = new ArrayList<>();

            if (root == null) {
                return ans;
            }

            Queue<TreeNode> queue = new LinkedList<>();

            TreeNode cur = root;
            queue.offer(cur);
            while (!queue.isEmpty()) {

                int c = queue.size();
                Integer rightest = null;
                while (c-- > 0) {

                    cur = queue.poll();
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                    rightest = cur.val;
                }

                if (rightest != null) {
                    ans.add(rightest);
                }
            }

            return ans;
        }
    }
}
