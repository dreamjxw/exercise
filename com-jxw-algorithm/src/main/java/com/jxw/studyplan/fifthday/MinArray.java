/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.studyplan.fifthday;

/**
 * @author jiaxingwu
 * @date 2022/1/10 下午10:40
 * @description https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class MinArray {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                return number;
            }
        }
        return min;
    }
}
