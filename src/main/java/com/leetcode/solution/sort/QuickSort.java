package com.leetcode.solution.sort;

import java.util.Random;

public class QuickSort {

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
            return randomSelect(arr, randomPivotIndex + 1, r, k);
        }
    }

    public static void randomSort(int[] arr) {
        randomSort(arr, 0, arr.length - 1);
    }

    public static void randomSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = randomPartition(arr, l, r);
            randomSort(arr, l, p - 1);
            randomSort(arr, p + 1, r);
        }
    }

    public static void sort(int[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {

        if (l < r) {
            int p = partition(arr, l, r);
            sort(arr, l, p - 1);
            sort(arr, p + 1, r);
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
