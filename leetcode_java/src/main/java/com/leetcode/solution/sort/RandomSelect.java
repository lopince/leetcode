package com.leetcode.solution.sort;

import java.util.Random;

public class RandomSelect {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 1, 4, 9, 8, 5, 6, 7};

        System.out.println(randomSelect(arr, 3));
    }

    private static int randomSelect(int[] arr, int k) {

        return randomSelect(arr, 0, arr.length - 1, k);
    }

    private static int randomSelect(int[] arr, int l, int r, int k) {

        if (l == r) {
            return arr[l];
        }

        int randomPivotIndex = randomPartition(arr, l, r);
        int rank = randomPivotIndex - l + 1;

        if (k == rank) {
            return arr[randomPivotIndex];
        } else if (k < rank) {
            return randomSelect(arr, l, randomPivotIndex - 1, k);
        } else {
            return randomSelect(arr, randomPivotIndex + 1, r, k - rank);
        }
    }

    private static int randomPartition(int[] arr, int l, int r) {

        int random = new Random().nextInt(r - l + 1) + l;
        swap(arr, random, r);
        return partition(arr, l, r);
    }

    private static int partition(int[] arr, int l, int r) {

        int pivot = arr[r];

        int i = l - 1;
        int j = l;
        for (; j < r; j++) {

            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        i++;
        swap(arr, i, r);

        return i;
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
