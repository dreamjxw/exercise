package com.jxw.leetcode.ten2twenty;

/**
 * @author jiaxingwu
 * @date 2019/8/12 19:21
 * @Description 第十四题  最长公共前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        String[] str = new String[]{"flower","flow","flight"};
        System.out.println(prefix.longestCommonPrefix(str));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int length = commonPrefix(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++) {
            length = commonPrefix(strs[i], strs[i - 1].substring(0, length));
        }
        return strs[0].substring(0, length);
    }

    private int commonPrefix(String l, String r) {
        int length = Math.min(l.length(), r.length());
        if (l.length() != length || r.length() != length) {
            l = l.substring(0, length);
            r = r.substring(0, length);
        }
        while (l.length() > 0 && r.length() > 0) {
            if (l.equals(r)) {
                break;
            }
            l = l.substring(0, l.length() - 1);
            r = r.substring(0, r.length() - 1);
        }
        return l.length();
    }
}
