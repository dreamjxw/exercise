/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.studyplan.fourthday;

/**
 * @author jiaxingwu
 * @date 2022/1/6 下午11:32
 * @description do something with this class...
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return -1;
    }
}
