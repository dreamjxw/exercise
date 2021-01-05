package com.jxw.common;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2020/5/18 14:18
 * @Description 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] data = new int[]{1, 3, 2, 7, 5, 4, 65, 8};
        System.out.println(Arrays.toString(insertSort(data)));
    }

    private static int[] insertSort(int[] data) {
        if (data == null || data.length == 1 || data.length == 0) {
            return data;
        }
        for (int i = 1; i < data.length; i++) {
            int flag = data[i];
            int temp = i;
            for (int j = i - 1; j >= 0; j--) {
                if (data[j] > flag) {
                    data[j + 1] = data[j];
                    temp = j;
                }
            }
            data[temp] = flag;
        }
        return data;
    }
}
