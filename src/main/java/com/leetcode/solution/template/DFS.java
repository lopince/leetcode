package com.leetcode.solution.template;

import com.leetcode.bean.GraphNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;

public class DFS {

    // public class GraphNode {
    //
    //    int val;
    //    List<GraphNode> neighbours;
    // }

    public static void dfs(GraphNode root, Consumer<GraphNode> consumer){

        Stack<GraphNode> stack = new Stack<>();
        stack.push(root);

        // using sentinel to record the visited node
        Set<GraphNode> sentinel = new HashSet<>();
        sentinel.add(root);

        while (!stack.isEmpty()){

            GraphNode node = stack.pop();

            // do something with node
            consumer.accept(node);

            if (node.getNeighbours().size() > 0) {
                for (GraphNode neighbour : node.getNeighbours()) {

                    // avoid cyclic
                    if (!sentinel.contains(neighbour)) {
                        stack.push(neighbour);
                        sentinel.add(neighbour);
                    }
                }
            }
        }
    }
}
