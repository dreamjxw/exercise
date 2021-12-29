package com.jxw.leetcode.zero2ten;

/**
 * @author jiaxingwu
 * @date 2019/8/6 17:12
 * @Description 第五题   最长回文子串
 */
public class LongestPalindrome {
    /**
     * 最长回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int i = s.length() - 1;
        int left = 0, right = i;
        char[] chars = s.toCharArray();
        while (i > 0) {
            if (checkPalindrome(chars, left++, right++)) {
                return s.substring(--left, right);
            }
            if (right == s.length()) {
                i--;
                left = 0;
                right = i;
            }
        }
        return null;
    }

    private boolean checkPalindrome(char[] chars, int i, int j) {
        while (i <= j) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }
}
