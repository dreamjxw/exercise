/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jiaxingwu
 * @date 2022/6/16 下午10:35
 * @description 给你一个整数数组 nums 和一个整数 k，请你在数组中找出 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 * <p>
 * k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
 * <p>
 * 0 <= i, j < nums.length
 * i != j
 * nums[i] - nums[j] == k
 * 注意，|val| 表示 val 的绝对值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/k-diff-pairs-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 数组中的kDiff数对 {

    public static void main(String[] args) {
        数组中的kDiff数对 main = new 数组中的kDiff数对();
        int[] ints = {3, 1, 4, 1, 5};
        int k = 2;
        int pairs = main.findPairs(ints, k);
        System.out.println(pairs);
    }

    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                // 存在多个相同值  不怕使用同一个
                map.put(num, -1);
            } else {
                map.put(num, i);
            }
        }
        Set<String> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isAdd(nums[i] - k, nums, i, map, set)) {
                result++;
            }
            if (isAdd(nums[i] + k, nums, i, map, set)) {
                result++;
            }
        }
        return result;
    }

    private boolean isAdd(int tag, int[] data, int index, Map<Integer, Integer> map,
                          Set<String> set) {
        if (!map.containsKey(tag)) {
            return false;
        }
        if (map.get(tag) == index) {
            return false;
        }
        String s1 = tag + "_" + data[index];
        String s2 = data[index] + "_" + tag;
        if (set.contains(s1) || set.contains(s2)) {
            return false;
        }
        set.add(s1);
        set.add(s2);
        return true;
    }
}
