package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/1/5 14:29
 * @description https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * eg：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(replaceSpace(str));
    }

    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                builder.append("%20");
            } else {

                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
