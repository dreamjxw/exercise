/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author jiaxingwu
 * @date 2023/6/4 16:48
 * @description do something with this class...
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = main.groupAnagrams(strs);
        System.out.println(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = map.containsKey(s) ? map.get(s) : new ArrayList<>();
            list.add(str);
            map.put(s, list);
        }
        return new ArrayList<>(map.values());
    }

    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        int result = 1;
        int count = 0;
        int flag = 0;
        for (Integer item : treeSet) {
            if (count == 0) {
                flag = item;
                count++;
                continue;
            }
            if (++flag == item) {
                count++;
            } else {
                flag = item;
                result = Math.max(result, count);
                count = 1;
            }
        }
        return Math.max(result, count);
    }
}
