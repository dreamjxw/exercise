/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

/**
 * @author jiaxingwu
 * @date 2022/1/5 下午11:07
 * @description do something with this class...
 */
public class 替换所有的问号 {

    public static void main(String[] args) {
        String s = new 替换所有的问号().modifyString("u???w");
        System.out.println(s);
    }

    private String str = "abcdefghijklmnopqrstuvwxyz";

    public String modifyString(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c1 = builder.charAt(i);
            String c = String.valueOf(c1);
            if (!c.equals("?")) {
                continue;
            }
            char start = 'a', end = 'a';
            if (i - 1 >= 0) {
                start = builder.charAt(i - 1);
            }
            if (i + 1 < builder.length()) {
                end = builder.charAt(i + 1);
            }
            builder.replace(i, i + 1, modify(start, end));
        }
        return builder.toString();
    }

    private String modify(char start, char end) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != start && str.charAt(i) != end) {
                return String.valueOf(str.charAt(i));
            }
        }
        return null;
    }
}
