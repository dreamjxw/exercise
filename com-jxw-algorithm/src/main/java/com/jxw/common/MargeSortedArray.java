package com.jxw.common;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2020/5/22 10:48
 * @Description 合并数组
 */
public class MargeSortedArray {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 0, 0, 0};
        int[] b = new int[]{2, 3, 4};
        int[] merge = merge(a, 3, b, 3);
        System.out.println(Arrays.toString(merge));
    }


    private static int[] merge(int[] a, int aLength, int[] b, int bLength) {
        int first = aLength - 1;
        int second = bLength - 1;
        int flag = aLength + bLength - 1;
        while (first >= 0 || second >= 0) {
            if (first < 0) {
                a[flag--] = b[second--];
                continue;
            }
            if (second < 0) {
                a[flag--] = a[first--];
                continue;
            }
            if (a[first] < b[second]) {
                a[flag--] = b[second--];
                continue;
            }
            a[flag--] = a[first--];
        }
        return a;
    }
}
