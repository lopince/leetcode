package com.leetcode.solution;

import java.util.HashMap;

public class LRUCache {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1); // cache is {1=1}
        cache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(cache.get(1));  // return 1
        cache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(cache.get(2));     // returns -1 (not found)
        cache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(cache.get(1));    // return -1 (not found)
        System.out.println(cache.get(3));    // return 3
        System.out.println(cache.get(4));    // return 4

    }

    private HashMap<Integer, Node> map;
    private LinkQueue queue;
    private int capacity;

    public LRUCache(int capacity) {

        this.map = new HashMap<>();
        this.queue = new LinkQueue();
        this.capacity = capacity;
    }

    // o(1)
    public int get(int key) {

        if (map.containsKey(key)) {

            Node cur = map.get(key);
            this.queue.remove(cur);
            this.queue.addLast(cur);

            return cur.val;
        } else {
            return -1;
        }
    }

    // o(1)
    public void put(int key, int value) {

        Node node;
        if (map.containsKey(key)){
            node = map.get(key);
            node.val = value;

            queue.remove(node);

        }else {

            node = new Node(key, value);

            if (capacity == queue.size){
                map.remove(queue.removeFirst());
            }
        }

        queue.addLast(node);
        map.put(key, node);
    }

    private class LinkQueue {

        // 每次把新加入的元素放到最后
        // 对头元素是最久未使用的，先删除他

        private int size;
        private Node head;
        private Node tail;

        LinkQueue() {

            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);

            this.head.pre = this.tail;
            this.head.next = this.tail;

            this.tail.pre = this.head;
            this.tail.next = this.head;

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

                head.next = first.next;
                first.next.pre = head;

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
        private int key;
        private int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
