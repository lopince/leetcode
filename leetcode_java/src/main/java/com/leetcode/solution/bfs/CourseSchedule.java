package com.leetcode.solution.bfs;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class CourseSchedule {

    private static class Solution {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // build indegrees
            int[] indegrees = new int[numCourses];
            for (int[] vec : prerequisites) {
                indegrees[vec[1]]++;
            }

            //
            Queue<Integer> queue = new LinkedBlockingDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegrees[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {

                int cur = queue.poll();
                for (int[] vec : prerequisites) {
                    if (cur == vec[0]) {
                        indegrees[vec[1]]--;
                        if (indegrees[vec[1]] == 0) {
                            queue.offer(vec[1]);
                        }
                    }
                }

                numCourses--;
                if (numCourses == 0) {
                    break;
                }
            }

            return numCourses == 0;
        }
    }
}
