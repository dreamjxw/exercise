package com.jxw.leetcode.zero2ten;

import java.util.HashMap;

/**
 * @author jiaxingwu
 * @date 2019/8/6 10:53
 * @Description 第三题  无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int i = lengthOfLongestSubstring.lengthOfLongestSubstringOption("abcddeak");
        System.out.println(i);
    }

    /**
     * 最长子串长度
     *
     * @param s
     * @return
     */
    private int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (maxLength < map.size()) {
                    maxLength = map.size();
                }
                i = map.get(s.charAt(i)) + 1;
                map.clear();
            }
            map.put(s.charAt(i), i);
        }
        return Math.max(maxLength, map.size());
    }

    /**
     * 优化
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringOption(String s) {
        int l = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(l, i).indexOf(s.charAt(i)) != -1) {
                l = s.indexOf(s.charAt(i), l) + 1;
            }
            dp[i + 1] = Math.max(dp[i], i - l + 1);
        }
        return dp[s.length()];
    }
}
