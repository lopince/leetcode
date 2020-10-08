package com.leetcode.solution.template;

import com.leetcode.bean.GraphNode;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

public class BFS {

    // public class GraphNode {
    //
    //    int val;
    //    List<GraphNode> neighbours;
    // }

    public static void bfs(GraphNode root, Consumer<GraphNode> consumer) {

        Queue<GraphNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);

        // using sentinel to record the visited node
        Set<GraphNode> sentinel = new HashSet<>();
        sentinel.add(root);

        while (!queue.isEmpty()) {

            // traverse current level
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                GraphNode node = queue.poll();
                if (node != null) {

                    // do something with node
                    consumer.accept(node);

                    if (node.getNeighbours().size() > 0) {
                        for (GraphNode neighbour : node.getNeighbours()) {

                            // avoid cyclic
                            if (!sentinel.contains(neighbour)) {
                                queue.offer(neighbour);
                                sentinel.add(neighbour);
                            }
                        }
                    }
                }
            }
        }
    }

}
