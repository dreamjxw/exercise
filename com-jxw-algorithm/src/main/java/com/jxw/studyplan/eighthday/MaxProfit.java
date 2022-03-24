/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.studyplan.eighthday;

/**
 * @author jiaxingwu
 * @date 2022/1/18 下午11:19
 * @description https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] ints = {7, 1, 5, 3, 6, 4};
        int i = new MaxProfit().maxProfit(ints);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            if (min > price) {
                min = price;
            }
            if (result < price - min) {
                result = price - min;
            }
        }
        return result;
    }
}
