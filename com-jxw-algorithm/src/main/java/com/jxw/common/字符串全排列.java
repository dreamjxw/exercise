package com.jxw.common;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * 字符串全排列
 */
public class 字符串全排列 {
    public static void main(String[] args) {
        String[] s = {"a", "b", "c"};
        permutation(s, 0, s.length - 1);
    }

    public static void permutation(String[] s, int from, int to) {
        if (to <= 1) {
            return;
        }
        if (from == to) {
            System.out.println(Arrays.toString(s));
            return;
        }
        for (int i = from; i <= to; i++) {
            exchange(s, i, from);
            permutation(s, from + 1, to);
            exchange(s, from, i);
        }
    }

    public static void exchange(String[] s, int i, int j) {
        String tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }


}