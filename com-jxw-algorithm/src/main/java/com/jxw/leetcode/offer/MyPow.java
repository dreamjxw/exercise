package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/20 14:18
 * @description https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class MyPow {
    public static void main(String[] args) {

        // double pow1 = new MyPow().myPow1(2, -2147483648);
        // System.out.println(pow1);
        // System.out.println(pow);
    }

    public double myPow1(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long m = n;
        boolean flag = m > 0;
        m = flag ? m : -m;
        double result = 1;
        while (m > 0) {
            if ((m & 1) == 1) {
                result *= x;
            }
            x *= x;
            m = m >> 1;
        }
        return flag ? result : 1 / result;
    }
}
