/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.周赛.第294场;

/**
 * @author jiaxingwu
 * @date 2022/5/23 上午11:17
 * @description 给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
 * https://leetcode.cn/problems/percentage-of-letter-in-string/
 */
public class 字母在字符串中的百分比 {
    public int percentageLetter(String s, char letter) {
        double sumLength = s.length();
        double count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                count++;
            }
        }
        return (int) ((count / sumLength) * 100);
    }
}
