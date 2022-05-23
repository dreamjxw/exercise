/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.studyplan.fourthday;

/**
 * @author jiaxingwu
 * @date 2022/1/6 下午10:20
 * @description https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();

        int[] ints = {3, 4, 2, 0, 0, 1};
        int repeatNumber = findRepeatNumber.findRepeatNumber(ints);
        System.out.println(repeatNumber);
    }

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
        }
        return nums[0];
    }
}
