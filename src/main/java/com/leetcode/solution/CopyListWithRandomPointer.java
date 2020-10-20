package com.leetcode.solution;

import com.leetcode.bean.RandomNode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {

        RandomNode node_4 = new RandomNode(4);
        RandomNode node_7 = new RandomNode(7);
        RandomNode node__2 = new RandomNode(-2);

        node_4.next = node_7;
        node_7.next = node__2;

        node_4.random = node__2;
        node_7.random = node_4;


    }

    private static class Solution {

        private Map<RandomNode, RandomNode> randomNodeMap = new HashMap<>();

        public RandomNode copyRandomList(RandomNode head) {

            if (head == null) {
                return null;
            }

            if (randomNodeMap.containsKey(head)) {
                return randomNodeMap.get(head);
            }

            RandomNode node = new RandomNode(head.val);
            randomNodeMap.put(head, node);

            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);

            return node;
        }
    }
}
