/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

/**
 * @author jiaxingwu
 * @date 2022/10/23 下午10:54
 * @description https://leetcode.cn/problems/merge-strings-alternately/
 */
public class 交替合并字符串 {

    public static void main(String[] args) {
        交替合并字符串 main = new 交替合并字符串();
        String a = "abcdef";
        String b = "kls";
        String s = main.mergeAlternately(a, b);
        System.out.println(s);
    }


    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int i = 0, j = 0, k = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i == word1.length()) {
                builder.append(word2.substring(j));
                break;
            }
            if (j == word2.length()) {
                builder.append(word1.substring(i));
                break;
            }
            if (k % 2 == 0) {
                builder.append(word1.charAt(i++));
            } else {
                builder.append(word2.charAt(j++));
            }
            k++;
        }
        return builder.toString();
    }
}
