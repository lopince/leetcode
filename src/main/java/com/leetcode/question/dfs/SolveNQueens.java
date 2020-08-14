package com.leetcode.question.dfs;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int n = 4;

        List<List<String>> queens = solution.solveNQueens(n);
        queens.forEach(
                queen -> {
                    System.out.println(queen);
                    System.out.println();
                });
    }

    private static class Solution {

        List<List<String>> outputs = new ArrayList<>();
        List<Integer[]> queens = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {

            backtrack(0, n, new Integer[n], new int[n][n]);

            for (Integer[] queen : queens){
                outputs.add(createOutput(n, queen));
            }

            return outputs;
        }

        private List<String> createOutput(int n, Integer[] queen) {

            List<String> output = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                StringBuilder line = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == queen[i]) {
                        line.append('Q');
                    } else {
                        line.append('.');
                    }
                }
                output.add(line.toString());
            }

            return output;
        }

        private void backtrack(int row, int n, Integer[] queen, int[][] board) {

            if (row == n) {
                queens.add(queen);
                return;
            }

            int colMax = board[0].length;
            for (int col = 0; col < colMax; col++) {

                int[][] bTemp = clone(board);
                if (addQueen(col, row, bTemp)) {

                    Integer[] qTemp = clone(queen);
                    qTemp[row] = col;

                    backtrack(row + 1, n, qTemp, bTemp);
                }
            }
        }

        private boolean addQueen(int col, int row, int[][] board) {

            if (board[row][col] == 1) {
                return false;
            }

            // mark queen
            markQueen(col, row, board, 1);

            return true;
        }

        private void markQueen(int col, int row, int[][] board, Integer mark) {

            // mark queen
            board[row][col] = mark;

            int colMax = board[0].length;
            int rowMax = board.length;

            // mark col
            for (int i = 0; i < rowMax; i++) {
                board[i][col] = mark;
            }

            // mark row
            for (int i = 0; i < colMax; i++) {
                board[row][i] = mark;
            }

            // mark dale
            int daleConst = col - row;
            for (int i = 0; i < colMax; i++) {
                for (int j = 0; j < rowMax; j++) {
                    if (i - j == daleConst) {
                        board[j][i] = mark;
                    }
                }
            }

            // mark hill
            int hillConst = col + row;
            for (int i = 0; i < colMax; i++) {
                for (int j = 0; j < rowMax; j++) {
                    if (i + j == hillConst) {
                        board[j][i] = mark;
                    }
                }
            }
        }

        private Integer[] clone(Integer[] array) {
            return array.clone();
        }

        private int[][] clone(int[][] array) {

            int maxY = array.length;
            int maxX = array[0].length;

            int[][] newArray = new int[maxY][maxX];

            for (int y = 0; y < maxY; y++) {
                System.arraycopy(array[y], 0, newArray[y], 0, maxX);
            }

            return newArray;
        }

    }
}
