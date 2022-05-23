/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.studyplan.fifthday;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jiaxingwu
 * @date 2022/1/10 下午10:45
 * @description https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1){
                return entry.getKey();
            }
        }
        return ' ';
    }
}
