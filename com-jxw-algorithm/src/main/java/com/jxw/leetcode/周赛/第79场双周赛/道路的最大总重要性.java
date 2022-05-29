/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.周赛.第79场双周赛;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiaxingwu
 * @date 2022/5/28 下午11:49
 * @description 给你一个整数 n ，表示一个国家里的城市数目。城市编号为 0 到 n - 1 。
 * <p>
 * 给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] 表示城市 ai 和 bi 之间有一条 双向 道路。
 * <p>
 * 你需要给每个城市安排一个从 1 到 n 之间的整数值，且每个值只能被使用 一次 。道路的 重要性 定义为这条道路连接的两座城市数值 之和 。
 * <p>
 * 请你返回在最优安排下，所有道路重要性 之和 最大 为多少。
 * <p>
 * https://leetcode.cn/contest/biweekly-contest-79/problems/maximum-total-importance-of-roads/
 */
public class 道路的最大总重要性 {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Long> map = new HashMap<>();
        for (int[] road : roads) {
            map.merge(road[0], 1L, Long::sum);
            map.merge(road[1], 1L, Long::sum);
        }

        List<Map.Entry<Integer, Long>> entrySet = new ArrayList<>(map.entrySet());
        Collections.sort(entrySet, new MyComparator());

        Map<Integer, Integer> mapping = new HashMap<>();
        for (Map.Entry<Integer, Long> entry : entrySet) {
            mapping.put(entry.getKey(), n--);
        }
        long result = 0L;
        for (int[] road : roads) {
            long road0 = mapping.get(road[0]);
            long road1 = mapping.get(road[1]);
            result += (road0 + road1);
        }
        return result;

    }

    static class MyComparator implements Comparator<Map.Entry<Integer, Long>> {
        @Override
        public int compare(Map.Entry<Integer, Long> o1, Map.Entry<Integer, Long> o2) {
            return (o2.getValue()).compareTo(o1.getValue());
        }
    }
}
