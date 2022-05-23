package com.jxw.leetcode.每日一题;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2021/1/22 19:56
 * @description
 */
public class 数组形式的整数加法 {
    public static void main(String[] args) {
        int[] ints = {0};
        数组形式的整数加法 数组形式的整数加法 = new 数组形式的整数加法();
        List<Integer> add = 数组形式的整数加法.addToArrayForm(ints, 23);
        System.out.println(add);
    }

    public List<Integer> addToArrayForm(int[] a, int k) {
        int aLength = a.length;
        int acc = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while (aLength > 0 || k > 0) {
            int i = aLength <= 0 ? 0 : a[aLength - 1];
            int j = k % 10;
            int h = i + j + acc;

            list.addFirst(h % 10);

            acc = h / 10;

            k /= 10;

            aLength--;
        }
        if (acc != 0) {
            list.addFirst(acc);
        }
        return list;
    }
}
