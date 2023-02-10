/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2022/6/28 下午10:48
 * @description 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/wiggle-sort-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 摆动排序II {
    public static void main(String[] args) {
        int[] ints = {1,5,1,1,6,4};
        wiggleSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void wiggleSort(int[] nums) {
        int[] result = new int[nums.length];
        System.arraycopy(nums, 0, result, 0, result.length);
        Arrays.sort(result);
        int j = nums.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = result[j--];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = result[j--];
        }
    }
}
