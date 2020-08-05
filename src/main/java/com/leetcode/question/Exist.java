package com.leetcode.question;

import java.util.LinkedList;

public class Exist {

    public static void main(String[] args) {

//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};

        char[][] board = {{'a'}};


        Solution solution = new Solution();
        System.out.println(solution.exist(board, "a"));
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

                int yMax = board.length - 1;
                int xMax = board[0].length - 1;

                for (int y = 0; y <= yMax; y++) {
                    for (int x = 0; x <= xMax; x++) {

                        backtrack(x, y, xMax, yMax, board, new int[yMax + 1][xMax + 1], words);

                        if (isExist) {
                            return true;
                        }
                    }
                }
            }

            return isExist;

        }

        private void backtrack(int curX, int curY, int xMax, int yMax, char[][] board, int[][] records, LinkedList<Character> words) {

            if (words.isEmpty()) {
                this.isExist = true;
            } else if (board[curY][curX] == words.getFirst()
                    && records[curY][curX] == 0) {

                char tmp = words.removeFirst();
                records[curY][curX] = 1;

                if (words.isEmpty()){
                    this.isExist = true;
                    return;
                }

                // up
                if (curY + 1 <= yMax) {
                    backtrack(curX, curY + 1, xMax, yMax, board, records, words);
                }

                // down
                if (curY - 1 >= 0) {
                    backtrack(curX, curY - 1, xMax, yMax, board, records, words);
                }

                // right
                if (curX + 1 <= xMax) {
                    backtrack(curX + 1, curY, xMax, yMax, board, records, words);
                }

                // left
                if (curX - 1 >= 0) {
                    backtrack(curX - 1, curY, xMax, yMax, board, records, words);
                }

                // resume
                words.addFirst(tmp);
                records[curY][curX] = 0;
            }
        }
    }
}
