/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.周赛.第79场双周赛;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jiaxingwu
 * @date 2022/5/28 下午11:50
 * @description 显示英文描述
 * 通过的用户数2883
 * 尝试过的用户数3049
 * 用户总通过次数2921
 * 用户总提交次数5123
 * 题目难度Medium
 * 给你一个聊天记录，共包含 n 条信息。给你两个字符串数组 messages 和 senders ，其中 messages[i] 是 senders[i] 发出的一条 信息 。
 * <p>
 * 一条 信息 是若干用单个空格连接的 单词 ，信息开头和结尾不会有多余空格。发件人的 单词计数 是这个发件人总共发出的 单词数 。注意，一个发件人可能会发出多于一条信息。
 * <p>
 * 请你返回发出单词数 最多 的发件人名字。如果有多个发件人发出最多单词数，请你返回 字典序 最大的名字。
 * <p>
 * 注意：
 * <p>
 * 字典序里，大写字母小于小写字母。
 * "Alice" 和 "alice" 是不同的名字。
 * https://leetcode.cn/contest/biweekly-contest-79/problems/sender-with-largest-word-count/
 */
public class 最多单词数的发件人 {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < senders.length; i++) {
            Set<Integer> set = map.get(senders[i]);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(i);
            map.put(senders[i], set);
        }
        int resultTemp = 0;
        String resultName = "";
        for (Map.Entry<String, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> value = entry.getValue();
            if (value == null) {
                continue;
            }
            int temp = 0;
            for (Integer item : value) {
                temp += messages[item].split(" ").length;
            }

            if (temp > resultTemp) {
                resultTemp = temp;
                resultName = entry.getKey();
            }
            if (temp == resultTemp && entry.getKey().compareTo(resultName) > 0) {
                resultName = entry.getKey();
            }
        }
        return resultName;
    }
}
