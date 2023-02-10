/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author jiaxingwu
 * @date 2022/6/26 下午2:28
 * @description 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1]
 * 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 * <p>
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
 * int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/random-pick-with-blacklist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 黑名单中的随机数 {

}

class Solution {
    Random random = new Random();
    Map<Integer, Integer> map;
    List<Integer> list;
    int num;
    boolean flag = false;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        num = n;
        list = new ArrayList();

        for (int value : blacklist) {
            map.put(value, -1);
        }

        // 黑名单多   找白名单
        if (blacklist.length >= n / 2) {
            for (int m = 0; m < n; m++) {
                if (map.containsKey(m)) {
                    continue;
                }
                list.add(m);
            }
            flag = true;
        } else {
            // 黑名单少   映射
            int i = 0;
            for (int j : blacklist) {
                while (map.containsKey(i) || i >= n) {
                    i++;
                    if (i >= n) {
                        i = 0;
                    }
                }
                map.put(j, i++);
            }
        }
    }

    public int pick() {
        if (flag) {
            return list.get(random.nextInt(list.size()));
        } else {
            int i = random.nextInt(num);
            return map.getOrDefault(i, i);
        }
    }
}
