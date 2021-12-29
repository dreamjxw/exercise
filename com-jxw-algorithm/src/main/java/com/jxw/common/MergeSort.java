package com.jxw.common;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {2, 5, 1, 8, 9, 3};
        System.out.println("归并排序start:" + Arrays.toString(array));
        mergeSort(array, new int[array.length], 0, array.length - 1);
        System.out.println("归并排序end" + Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int[] temparray, int left,
                                 int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, temparray, left, middle);
            mergeSort(array, temparray, middle + 1, right);
            merge(array, temparray, left, middle + 1, right);
        }
    }

    public static void merge(int[] array, int[] temparray, int left,
                             int middle, int right) {
        int leftEnd = middle - 1;
        int rightStart = middle;
        int tempIndex = left;
        int tempLength = right - left + 1;
        while ((left <= leftEnd) && (rightStart <= right)) {

            if (array[left] < array[rightStart])
                temparray[tempIndex++] = array[left++];
            else
                temparray[tempIndex++] = array[rightStart++];
        }

        while (left <= leftEnd)
            temparray[tempIndex++] = array[left++];

        while (rightStart <= right)
            temparray[tempIndex++] = array[rightStart++];

        for (int i = 0; i < tempLength && right >= 0; i++) {
            array[right] = temparray[right];
            right--;
        }
    }
}