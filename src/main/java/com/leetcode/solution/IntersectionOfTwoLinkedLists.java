package com.leetcode.solution;

import com.leetcode.bean.ListNode;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

    }

    private static class Solution {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            if(headA == null || headB == null) return null;
            ListNode pA = headA, pB = headB;
            while(pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
    }
}
