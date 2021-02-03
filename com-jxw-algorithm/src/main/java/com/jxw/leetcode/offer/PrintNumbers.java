package com.jxw.leetcode.offer;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2021/2/3 20:13
 * @description https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * <p>
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class PrintNumbers {
    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        int[] ints = printNumbers.printNumbers(3);
        System.out.println(Arrays.toString(ints));
    }

    public int[] printNumbers(int n) {
        int temp = 1;
        for (int i = 0; i < n; i++) {
            temp *= 10;
        }
        int[] data = new int[temp - 1];
        for (int i = 0; i < temp - 1; i++) {
            data[i] = i + 1;
        }
        return data;
    }
}
