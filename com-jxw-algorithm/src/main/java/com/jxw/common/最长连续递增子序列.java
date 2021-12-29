package com.jxw.common;

public class 最长连续递增子序列 {
    public static void main(String[] args) {
        int a[] = {3, 6, 2, 8, 4, 6, 7, 8};
        if (a.length == 1) {
            return;
        }
        int[] b = new int[a.length];
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                b[i] = b[i - 1] + 1;
                continue;
            }
            b[i] = 1;
        }
        int max = b[0], index = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] > max) {
                max = b[i];
                index = i;
            }
        }
        StringBuilder str = new StringBuilder();
        while (max > 0) {
            str.append(a[index]);
            index--;
            max--;
        }
        System.out.println(str.toString());
    }


//    public static void main(String[] args) {
//        int a[] = {3, 6, 2, 8, 4, 6, 7, 8};
//        int b[] = new int[a.length];
//        b[0] = -1;
//        for (int i = 1; i < a.length; i++) {
//            if (a[i] > a[i - 1]) {
//                b[i] = b[i - 1] + 1;
//            } else {
//                b[i] = 1;
//            }
//        }
//        int max = b[0], index = 0;
//        for (int i = 1; i < b.length; i++) {
//            if (b[i] > max) {
//                max = b[i];
//                index = i;
//            }
//        }
//        for (int i = a.length - b[index]; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }
//    }
}