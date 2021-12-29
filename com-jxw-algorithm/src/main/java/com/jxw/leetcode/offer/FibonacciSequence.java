package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/1/5 18:05
 * @description 斐波那契数列
 * <p>
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        int fib = fib(4);
        System.out.println(fib);
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int i, j = 1, k = 1;
        for (int l = 2; l < n; l++) {
            i = j;
            j = k;
            k = (i + j) % 1000000007;
        }
        return k;

    }
}
