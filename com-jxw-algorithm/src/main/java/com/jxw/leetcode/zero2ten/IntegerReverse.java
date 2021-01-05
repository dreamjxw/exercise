package com.jxw.leetcode.zero2ten;


/**
 * @author jiaxingwu
 * @date 2019/8/6 18:40
 * @Description 第七题  整数反转--- 32 位的有符号整数
 */
public class IntegerReverse {
    public static void main(String[] args) {
        IntegerReverse ir = new IntegerReverse();
        System.out.println(ir.reverse(-112));
    }

    public int reverse(int x) {
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }
        int flag = 1;
        if (x < 0) {
            x = -x;
            flag = -1;
        }
        long result = 0;
        while (x > 0) {
            result *= 10;
            result += (x % 10);
            x = x / 10;
            if (result != (int) result) {
                return 0;
            }
        }
        return (int) result * flag;
    }
}
