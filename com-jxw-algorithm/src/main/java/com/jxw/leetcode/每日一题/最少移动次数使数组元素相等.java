/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2022/5/19 上午11:49
 * @description 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * <p>
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 */
public class 最少移动次数使数组元素相等 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int midNum;
        // 找到中位数
        if (nums.length % 2 == 0) {
            midNum = (nums[nums.length >> 1] + nums[(nums.length >> 1) - 1]) >> 1;
        } else {
            midNum = nums[nums.length >> 1];
        }
        int result = 0;
        for (int num : nums) {
            result += Math.abs(num - midNum);
        }
        return result;
    }
}
