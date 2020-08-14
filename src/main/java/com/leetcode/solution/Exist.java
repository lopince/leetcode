package com.leetcode.solution;

import java.util.*;

public class Exist {

    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};


        Solution solution = new Solution();
        System.out.println(solution.exist(board, "ABCB"));
    }

    private static class Solution {

        private boolean isExist;

        public boolean exist(char[][] board, String word) {

            isExist = false;

            if (word != null && word.length() > 0) {

                LinkedList<Character> words = new LinkedList<>();

                char[] wordArray = word.toCharArray();
                for (char c : wordArray) {
                    words.add(c);
                }

                char root = words.getFirst();
                int yMax = board.length - 1;
                int xMax = board[0].length - 1;

                for (int y = 0; y <= yMax; y++) {
                    for (int x = 0; x <= xMax; x++) {

                        if (root == board[y][x]) {
                            words.removeFirst();

                            int[][] records = new int[yMax + 1][xMax + 1];
                            records[y][x] = 1;

                            backtrack(x, y, xMax, yMax, board, records, words);

                            if (isExist){
                                return true;
                            }

                            records[y][x] = 0;
                            words.addFirst(root);
                        }
                    }
                }
            }

            return isExist;

        }

        private void backtrack(int curX, int curY, int xMax, int yMax, char[][] board, int[][] records, LinkedList<Character> words) {

            if (words.isEmpty()) {
                this.isExist = true;

            } else {
                char root = words.removeFirst();

                //up
                if (isExist){
                    return;
                }
                if (curY + 1 <= yMax) {

                    if (board[curY + 1][curX] == root
                            && records[curY + 1][curX] != 1) {

                        records[curY + 1][curX] = 1;
                        backtrack(curX, curY + 1, xMax, yMax, board, records, words);
                        records[curY + 1][curX] = 0;
                    }
                }

                if (isExist){
                    return;
                }
                // down
                if (curY - 1 >= 0) {

                    if (board[curY - 1][curX] == root
                            && records[curY - 1][curX] != 1) {

                        records[curY - 1][curX] = 1;
                        backtrack(curX, curY - 1, xMax, yMax, board, records, words);
                        records[curY - 1][curX] = 0;
                    }
                }

                if (isExist){
                    return;
                }
                // left
                if (curX - 1 >= 0) {

                    if (board[curY][curX - 1] == root
                            && records[curY][curX - 1] != 1) {

                        records[curY][curX - 1] = 1;
                        backtrack(curX - 1, curY, xMax, yMax, board, records, words);
                        records[curY][curX - 1] = 0;
                    }
                }

                if (isExist){
                    return;
                }
                // right
                if (curX + 1 <= xMax) {

                    if (board[curY][curX + 1] == root
                            && records[curY][curX + 1] != 1) {

                        records[curY][curX + 1] = 1;
                        backtrack(curX + 1, curY, xMax, yMax, board, records, words);
                        records[curY][curX + 1] = 0;
                    }
                }

                words.addFirst(root);
            }
        }
    }
}
