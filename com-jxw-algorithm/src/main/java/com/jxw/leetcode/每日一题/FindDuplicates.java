/*
 * Copyright (C) 2022 Dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2022/5/10 上午9:39
 * @description https://leetcode.cn/problems/find-all-duplicates-in-an-array/
 */
public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                list.add(num);
            } else {
                nums[num - 1] = nums[num - 1] * -1;
            }

        }
        return list;
    }
}
