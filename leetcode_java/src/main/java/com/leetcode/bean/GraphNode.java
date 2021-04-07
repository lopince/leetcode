package com.leetcode.bean;

import com.google.common.collect.Lists;

import java.util.List;

public class GraphNode {

    String val;
    List<GraphNode> neighbours;

    public GraphNode(String val) {
        this.val = val;
        neighbours = Lists.newArrayList();
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public List<GraphNode> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<GraphNode> neighbours) {
        this.neighbours = neighbours;
    }


}
