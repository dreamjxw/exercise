/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.周赛.第79场双周赛;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaxingwu
 * @date 2022/5/28 下午11:48
 * @description 给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。
 * <p>
 * 如果对于 每个 0 <= i < n 的下标 i ，都满足数位 i 在 num 中出现了 num[i]次，那么请你返回 true ，否则返回 false 。
 * https://leetcode.cn/contest/biweekly-contest-79/problems/check-if-number-has-equal-digit-count-and-digit-value/
 */
public class 判断一个数的数字计数是否等于数位的值 {
    public boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            Integer key = (int) num.charAt(i) - 48;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        for (int i = 0; i < num.length(); i++) {
            Integer temp = map.getOrDefault(i, 0);
            Integer value = (int) num.charAt(i) - 48;
            if (!temp.equals(value)) {
                return false;
            }
        }
        return true;
    }
}
