package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/18 11:44
 * @description https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class Add {
    public int add(int a, int b) {
        while (b != 0) {
            // 进位
            int c = (a & b) << 1;
            // 非进位和
            a ^= b;

            b = c;
        }
        return b;
    }
}
