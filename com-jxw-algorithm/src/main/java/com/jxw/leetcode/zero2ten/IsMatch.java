package com.jxw.leetcode.zero2ten;

/**
 * @author jiaxingwu
 * @date 2019/8/7 18:16
 * @Description 第十题  正则表达式匹配
 */
public class IsMatch {
    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        System.out.println(isMatch.isMatch("abcd", "a.*d"));

    }

    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        if (s == null || p == null) {
            return false;
        }
        int length = Math.max(s.length(), p.length());
        for (int i = 0; i < length; i++) {

        }
        return true;
    }
}
