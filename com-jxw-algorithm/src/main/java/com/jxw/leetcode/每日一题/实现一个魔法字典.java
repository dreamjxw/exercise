/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jiaxingwu
 * @date 2022/7/11 下午7:08
 * @description do something with this class...
 */
public class 实现一个魔法字典 {
}

class MagicDictionary {
    Map<Integer, List<String>> dataMap;

    public MagicDictionary() {
        dataMap = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        dataMap = Arrays.stream(dictionary).collect(Collectors.groupingBy(String::length));
    }

    public boolean search(String searchWord) {
        List<String> list = dataMap.get(searchWord.length());
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (String str : list) {
            int temp = 0;
            int i = 0;
            int j = 0;
            while (i < str.length() && j < searchWord.length()) {
                if (temp > 1) {
                    break;
                }
                if (str.charAt(i++) != searchWord.charAt(j++)) {
                    temp++;
                }
            }
            if (temp == 1) {
                return true;
            }
        }
        return false;
    }
}
