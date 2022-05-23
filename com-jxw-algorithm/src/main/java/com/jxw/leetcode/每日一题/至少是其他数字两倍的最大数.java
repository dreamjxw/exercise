/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

/**
 * @author jiaxingwu
 * @date 2022/1/13 下午5:22
 * @description do something with this class...
 */
public class 至少是其他数字两倍的最大数 {
    public static void main(String[] args) {
        int[] ints = {10, 2, 3, 4};
        int i = dominantIndex(ints);
        System.out.println(i);
    }

    public static int dominantIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int maxIndex = 0;
        int secondMax = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                secondMax = nums[maxIndex];
                maxIndex = i;
            }
            if (nums[i] > secondMax && nums[i] < nums[maxIndex]) {
                secondMax = nums[i];
            }
        }
        return secondMax * 2 <= nums[maxIndex] ? maxIndex : -1;
    }
}
