package com.jxw.leetcode.ten2twenty;

import java.util.LinkedList;

/**
 * @author jiaxingwu
 * @date 2019/9/6 14:13
 * @Description 第二十题    有效的括号
 */
public class IsVaild {
    public static void main(String[] args) {
        String str = "(((((((((";
        System.out.println(new IsVaild().isValid(str));
    }

    public boolean isValid(String s) {
        if (s == null || s == "" || (s.length() % 2) != 0) {
            return false;
        }
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            /*左括号继续走*/
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                list.add(s.charAt(i));
                if (i == s.length() - 1) {
                    return false;
                }
                continue;
            }
            /*第一个是右括号肯定false*/
            if (i <= 0) {
                return false;
            }
            /*右括号的前一个不是它匹配的左括号——————一对括号的asc码差值为1或2*/
            Character last = list.removeLast();
            int del = s.charAt(i) - last;
            if (del != 1 && del != 2) {
                return false;
            }
        }
        return true;
    }
}
