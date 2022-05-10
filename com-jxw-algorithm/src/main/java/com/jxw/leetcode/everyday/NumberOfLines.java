/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.everyday;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * 输入:
 * widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "bbbcccdddaaa"
 * 输出: [2, 4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-lines-to-write-string
 */
public class NumberOfLines {
    public int[] numberOfLines(int[] widths, String s) {
        int temp = 0;
        int rowNum = 1;
        for (int i = 0; i < s.length(); i++) {
            int number = widths[s.charAt(i) - 'a'];
            temp += number;
            if (temp > 100) {
                rowNum++;
                temp = 0;
                i--;
            }
        }
        return new int[]{rowNum, temp};
    }

    public static void main(String[] args) {
        String a = "bbbcccdddaaa";
        int[] ints = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10};
        int[] ints1 = new NumberOfLines().numberOfLines(ints, a);
        System.out.println(Arrays.toString(ints1));
    }
}
