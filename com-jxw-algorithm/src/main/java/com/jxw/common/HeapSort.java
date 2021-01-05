package com.jxw.common;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = {3, 6, 5, 7, 2, 8, 9, 4, 1};
        System.out.println("堆排序start:" + Arrays.toString(a));
        heapsort(a);
        System.out.println("堆排序end:" + Arrays.toString(a));
    }

    public static void heapsort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            buildheap(a, a.length - 1 - i);
            swap(a, 0, a.length - 1 - i);
        }
    }

    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    public static void buildheap(int a[], int last) {
        for (int i = (last - 1) / 2; i >= 0; i--) {
            int child, flag;
            for (flag = a[i]; (2 * i + 1) <= last; i = child) {
                child = 2 * i + 1;
                if ((child + 1) <= last && a[child] < a[child + 1]) {
                    child++;
                }
                if (flag < a[child]) {
                    a[i] = a[child];
                } else {
                    break;
                }
            }
            a[i] = flag;
        }
    }
}