package com.jxw.common;

public class 最长递增子序列 {
    public static void main(String[] args) {
        int a[] = {203, 39, 186, 207, 83, 80, 89, 237, 247};
        int b[] = new int[a.length];
        int max = 0;
        for (int i = 0; i < b.length; i++) {
            b[i] = 1;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] <= a[i]) {
                    b[i] = Math.max(b[j] + 1, b[i]);
                }
            }
            max = Math.max(max, b[i]);
        }
        System.out.println(max);
    }
}