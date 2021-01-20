package com.leetcode.bean;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode gen(Integer... vals) {

        ListNode head = null;

        if (vals.length > 0) {

            head = new ListNode(vals[0]);

            if (vals.length > 1) {

                ListNode cur = head;
                for (int i = 1; i < vals.length; i++) {

                    ListNode temp = new ListNode(vals[i]);
                    cur.next = temp;
                    cur = temp;
                }
            }
        }

        return head;
    }
}
