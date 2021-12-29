package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/8 18:26
 * @description https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        char uniqChar = new FirstUniqChar().firstUniqChar("cc");
        System.out.println(uniqChar);
    }

    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }

        int flag = 0;
        for (int i = 1; flag < s.length() && i < s.length(); ) {
            if (s.charAt(flag) == s.charAt(i) && i != flag) {
                flag++;
                i = 0;
                continue;
            }
            i++;
        }
        return flag < s.length() ? s.charAt(flag) : ' ';
    }
}
