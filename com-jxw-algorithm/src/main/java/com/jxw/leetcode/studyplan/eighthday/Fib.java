/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.studyplan.eighthday;

/**
 * @author jiaxingwu
 * @date 2022/1/18 下午10:57
 * @description https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class Fib {
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int f0 = 0;
        int f1 = 1;
        int fn = f0 + f1;
        for (int i = 2; i <= n; i++) {
            fn = (f0 + f1);
            f0 = f1;
            f1 = fn % 1000000007;
        }
        return fn % 1000000007;
    }
}
