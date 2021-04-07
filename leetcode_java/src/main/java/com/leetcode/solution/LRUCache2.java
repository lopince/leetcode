package com.leetcode.solution;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 extends LinkedHashMap<Integer, Integer>{

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);

        System.out.println(cache.get(1));

        System.out.println(cache.get(2));
    }

    private int capacity;

    public LRUCache2(int capacity) {

        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > capacity;
    }
}
