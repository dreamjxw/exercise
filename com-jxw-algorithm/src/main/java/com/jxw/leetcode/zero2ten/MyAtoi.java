package com.jxw.leetcode.zero2ten;

/**
 * @author jiaxingwu
 * @date 2019/8/7 10:08
 * @Description 第八题  字符串转换整数 (atoi)
 */
public class MyAtoi {
    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("9223372036854775808"));
    }

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        long result = 0;
        int flags = 0;
        for (int i = 0; i < chars.length; i++) {
            /*空格*/
            if (chars[i] == 32 && flags == 0) {
                continue;
            }
            /*+号---遇到第一个+号*/
            if (chars[i] == 43 && flags == 0) {
                flags = 1;
                continue;
            }
            /*-号---遇到第一个-号*/
            if (chars[i] == 45 && flags == 0) {
                flags = -1;
                continue;
            }
            flags = (flags == -1) ? -1 : 1;
            /*0---48  9---57*/
            if (chars[i] < 48 || chars[i] > 57) {
                break;
            }
            result *= 10;
            result += (chars[i] - 48);
            /*如果不等于则说明已经溢出了*/
            if (result != (int) result) {
                return flags == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int) result * flags;
    }
}
