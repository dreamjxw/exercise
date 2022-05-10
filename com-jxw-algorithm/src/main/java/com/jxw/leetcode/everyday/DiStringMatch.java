/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.everyday;

/**
 * @author jiaxingwu
 * @date 2022/5/10 上午9:39
 * @description https://leetcode.cn/problems/di-string-match/
 */
public class DiStringMatch {

    public int[] diStringMatch(String s) {
        int i = 0;
        int j = s.length();
        int[] result = new int[j + 1];
        for (int k = 0; k < s.length(); k++) {
            result[k] = s.charAt(k) == 'I' ? i++ : j--;
        }
        result[result.length - 1] = i;
        return result;
    }
}
