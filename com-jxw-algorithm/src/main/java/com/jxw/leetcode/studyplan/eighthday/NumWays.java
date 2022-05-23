/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.studyplan.eighthday;

/**
 * @author jiaxingwu
 * @date 2022/1/18 下午11:11
 * @description https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class NumWays {
    public static void main(String[] args) {
        int i = new NumWays().numWays(7);
        System.out.println(i);
    }

    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int f0 = 1;
        int f1 = 1;
        int f2 = f0 + f1;
        for (int i = 2; i <= n; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2 % 1000000007;

        }
        return f2 % 1000000007;
    }
}
