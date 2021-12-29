package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/1/25 17:05
 * @description https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * <p>
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * >>> 无符号右移
 * >> 有符号右移   如果是正数，则最高位补0，如果是负数，则最高位补1
 *
 */
public class HammingWeight {


    public static void main(String[] args) {
        HammingWeight weight = new HammingWeight();
        int i = weight.hammingWeight(00000000000000000000001111111111);
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
