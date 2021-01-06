package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/1/6 21:09
 * @description https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class NumWays {
    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        System.out.println(numWays.numWays(7));
    }

    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }

        int i, j = 1, r = 1;
        for (int k = 2; k <= n; k++) {
            i = j;
            j = r;
            r = (i + j) % 1000000007;
        }

        return r;
    }
}
