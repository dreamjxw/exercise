package com.jxw.leetcode.zero2ten;

import java.util.Objects;

/**
 * @author jiaxingwu
 * @date 2019/8/6 17:13
 * @Description 第6题  Z 字形变换
 */
public class ZConvert {
    public static void main(String[] args) {
        ZConvert zConvert = new ZConvert();
        System.out.println(zConvert.convert("LEETCODEISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1 || numRows >= s.length()) {
            return s;
        }
        int t = 2 * (numRows - 1);
        StringBuilder[] result = new StringBuilder[numRows];
        for (int i = 0; i < s.length(); i++) {
            int flag = i % t;
            if (flag > t / 2) {
                flag = t - flag;
            }
            if (Objects.isNull(result[flag])) {
                result[flag] = new StringBuilder().append(s.charAt(i));
            } else {
                result[flag] = result[flag].append(s.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder stringBuilder : result) {
            builder.append(stringBuilder);
        }
        return builder.toString();
    }
}
