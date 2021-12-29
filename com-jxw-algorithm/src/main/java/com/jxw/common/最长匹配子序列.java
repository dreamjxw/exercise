package com.jxw.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2020/5/22 19:14
 * @Description 最长匹配子序列
 */
public class 最长匹配子序列 {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        System.out.println(findLongestWord(s, list));
    }

    public static String findLongestWord(String s, List<String> d) {
        if (s == null || d == null || d.size() == 0) {
            return "";
        }
        String longestStr = "";
        for (String str : d) {
            int i = 0, j = 0;
            while (i < s.length() && j < str.length()) {
                if (s.charAt(i) == str.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == str.length() && longestStr.length() <= j) {
                if (longestStr.length() == j) {
                    longestStr = longestStr.compareTo(str) > 0 ? str : longestStr;
                    continue;
                }
                longestStr = str;
            }
        }
        return longestStr;
    }
}
