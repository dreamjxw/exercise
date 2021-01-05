package com.jxw.common;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2020/5/18 14:44
 * @Description 快排
 */
public class QuickSort {
    public static void main(String[] arg0) {
        int[] a = {12, 20, 5, 16, 15, 1, 30, 45};
        quick(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quick(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        int flag = a[left];
        int i = left, j = right;
        while (i < j) {
            for (; i < j && a[j] > flag; j--) {
            }
            for (; i < j && a[i] <= flag; i++) {
            }
            int q = a[i];
            a[i] = a[j];
            a[j] = q;
        }
        int temp = a[left];
        a[left] = a[i];
        a[i] = temp;

        quick(a, left, i - 1);
        quick(a, i + 1, right);
    }
}
