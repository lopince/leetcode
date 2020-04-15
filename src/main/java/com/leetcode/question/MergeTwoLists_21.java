package com.leetcode.question;

import com.leetcode.bean.ListNode;

public class MergeTwoLists_21 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            if (l1 == null && l2 == null) return null;

            ListNode head = null;
            ListNode cNode = null;
            while (l1 != null && l2 != null) {

                ListNode node;
                if (l1.val < l2.val) {
                    node = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    node = new ListNode(l2.val);
                    l2 = l2.next;
                }

                if (head == null) {
                    head = node;
                } else {
                    cNode.next = node;
                }
                cNode = node;
            }

            ListNode resL = l1 != null?l1:l2;
            while (resL != null){
                ListNode node = new ListNode(resL.val);
                if (head == null) {
                    head = node;
                } else {
                    cNode.next = node;
                }
                cNode = node;
                resL = resL.next;
            }

            return head;
        }
    }
}
