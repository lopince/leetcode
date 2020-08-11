package com.leetcode.question.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.jar.JarOutputStream;
import java.util.stream.Collectors;

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

        List<List<String>> queens = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {

            backtrack(0, n, initQueen(n), new int[n][n]);

            return queens;
        }

        private List<String> initQueen(int n) {

            int counter = n;
            StringBuilder line = new StringBuilder();
            while (counter-- > 0) {
                line.append('.');
            }

            counter = n;
            List<String> queen = new ArrayList<>();
            while (counter-- > 0){
                queen.add(line.toString());
            }

            return queen;
        }

        private void backtrack(int row, int n, List<String> queen, int[][] board) {

            if (row == n) {
                queens.add(queen);
                return;
            }

            int colMax = board[0].length;
            for (int col = 0; col < colMax; col++) {

                int[][] bTemp = clone(board);
                if (addQueen(col, row, bTemp)) {

                    List<String> qTemp = new ArrayList<>(queen);
                    String line = qTemp.get(row);
                    qTemp.set(row, replace(line, col, 'Q'));


                    backtrack(row + 1, n, qTemp, bTemp);
                }
            }
        }

        private String replace(String s, int index, char c){

            char[] cs = s.toCharArray();
            cs[index] = c;

            return new String(cs);
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
