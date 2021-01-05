package com.jxw.common;

/**
 * @author jiaxingwu
 * @date 2020/5/22 19:39
 * @Description
 */
public class TopK {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1, 5, 6, 4};
        int key = 6;
        System.out.println(topK(a, key));
    }

    private static int topK(int[] a, int key) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int k = findK(a, i, j);
            if ((k + 1) == key) {
                return a[k];
            }
            if (k > key) {
                j = k - 1;
            }
            if (k < key) {
                i = k + 1;
            }
        }
        throw new RuntimeException("未查询到");
    }


    private static int findK(int[] a, int left, int right) {
        int flag = left;
        int temp;
        while (left < right) {
            while (left < right && a[right] <= a[flag]) {
                right--;
            }
            while (left < right && a[left] > a[flag]) {
                left++;
            }
            temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }
        temp = a[flag];
        a[flag] = a[left];
        a[left] = temp;
        return left;
    }
}
