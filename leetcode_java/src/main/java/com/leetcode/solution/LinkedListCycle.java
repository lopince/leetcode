package com.leetcode.solution;

import com.leetcode.bean.ListNode;

import java.util.HashSet;

public class LinkedListCycle {

    public static void main(String[] args) {


    }

    private static class Solution {

        public boolean hasCycle(ListNode head) {

            HashSet<ListNode> set = new HashSet<>();

            ListNode cur = head;
            while (cur != null) {
                if (set.contains(cur)) {
                    return true;
                } else {
                    set.add(cur);
                    cur = cur.next;
                }
            }

            return false;
        }
    }
}
