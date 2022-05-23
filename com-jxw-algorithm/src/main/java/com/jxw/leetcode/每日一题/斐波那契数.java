package com.jxw.leetcode.每日一题;

/**
 * @author jiaxingwu
 * @date 2021/1/4 15:57
 * @description https://leetcode-cn.com/problems/fibonacci-number/
 */
public class 斐波那契数 {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int i, j = 1, k = 1;
        for (int m = 2; m < n; m++) {
            i = j;
            j = k;
            k = i + j;
        }
        return k;
    }
}
