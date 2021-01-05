package com.jxw.leetcode.zero2ten;

/**
 * @author jiaxingwu
 * @date 2019/8/7 16:01
 * @Description 第九题    判断回文数字
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(1));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int y = 0;
        int z = x;
        while (z > 0) {
            y *= 10;
            y += (z % 10);
            z /= 10;
        }
        return x == y;

    }
}
