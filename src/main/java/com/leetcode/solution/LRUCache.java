package com.leetcode.solution;

import java.util.HashMap;

public class LRUCache {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);

        System.out.println(cache.get(1));

        System.out.println(cache.get(2));
    }

    private LinkedQueue queue;
    private HashMap<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {

        this.queue = new LinkedQueue();
        this.map = new HashMap<>();

        this.capacity = capacity;
    }

    public int get(int key) {

        if (map.containsKey(key)) {

            Node node = map.get(key);
            queue.remove(node);
            queue.addLast(node);

            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int val) {

        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = val;

            queue.remove(node);

        } else {
            node = new Node(key, val);

            if (queue.size == capacity) {
                map.remove(queue.removeFirst());
            }
        }

        queue.addLast(node);
        map.put(key, node);
    }

    private class LinkedQueue {

        // do not store data
        private Node head;
        private Node tail;
        private int size;

        public LinkedQueue() {

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            head.pre = tail;

            tail.pre = head;
            tail.next = head;

            this.size = 0;
        }

        public void remove(Node node) {

            node.pre.next = node.next;
            node.next.pre = node.pre;

            size--;
        }

        public int removeFirst() {

            if (head.next != tail) {

                Node first = head.next;
                first.pre.next = first.next;
                first.next.pre = first.pre;

                size--;

                return first.key;
            } else {
                return -1;
            }
        }

        public void addLast(Node node) {

            Node last = tail.pre;
            last.next = node;
            tail.pre = node;

            node.pre = last;
            node.next = tail;

            size++;
        }
    }

    private class Node {

        private Node pre;
        private Node next;
        private int val;
        private int key;

        public Node(int key, int val) {

            this.key = key;
            this.val = val;
        }
    }
}
