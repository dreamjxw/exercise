/*
 * Copyright (C) 2022 dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiaxingwu
 * @date 2022/1/30 下午4:36
 * @description https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 */
public class 两句话中的不常见单词 {


    public String[] uncommonFromSentences(String s1, String s2) {
        String str = s1 + " " + s2;
        Map<String, Integer> map = new HashMap<>();
        String[] split = str.split(" ");
        for (String s : split) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
                continue;
            }
            map.put(s, 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }
}
