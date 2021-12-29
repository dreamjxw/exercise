package com.jxw.leetcode.offer;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2021/2/20 18:21
 * @description
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] ints = {0, 0, 1, 3, 4, 5, 0, 7, 6, 7};
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] leastNumbers = getLeastNumbers.getLeastNumbers(ints, 9);
        System.out.println(Arrays.toString(leastNumbers));
    }


    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        int i = 0, j = arr.length - 1;
        while (true) {
            int index = quickSort(arr, i, j);
            if (index == (k - 1)) {
                int[] ints = new int[k];
                System.arraycopy(arr, 0, ints, 0, k);
                return ints;
            }
            if (index > (k - 1)) {
                j = index - 1;
            }
            if (index < (k - 1)) {
                i = index + 1;
            }
        }
    }


    private int quickSort(int[] arr, int left, int right) {
        int i = left, j = right;
        int flag = arr[left];
        while (i < j) {
            for (; i < j && arr[j] > flag; j--) {
            }
            for (; i < j && arr[i] <= flag; i++) {
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int temp = arr[i];
        arr[i] = arr[left];
        arr[left] = temp;
        return i;
    }
}
