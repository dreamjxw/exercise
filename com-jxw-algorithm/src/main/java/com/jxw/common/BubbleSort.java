package com.jxw.common;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2020/5/18 14:06
 * @Description 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] data = new int[]{1, 3, 5, 7, 2, 4, 65, 8};
        System.out.println(Arrays.toString(bubbleSort(data)));
    }

    private static int[] bubbleSort(int[] data) {
        if (data == null || data.length == 1 || data.length == 0) {
            return data;
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] < data[j + 1]) {
                    int temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                }
            }
        }
        return data;
    }
}
