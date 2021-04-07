package com.leetcode.solution;

import com.leetcode.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {

    private static class Solution {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();

            ListNode cur = head;
            while (cur != null) {
                if (set.contains(cur)) {
                    return cur;
                }

                set.add(cur);
                cur = cur.next;
            }

            return null;
        }
    }
}
