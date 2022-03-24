/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.studyplan.fourthday;

/**
 * @author jiaxingwu
 * @date 2022/1/6 下午10:55
 * @description https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Search {
    public static void main(String[] args) {
        int[] ints = {1, 3};

        int search = new Search().search(ints, 1);
        System.out.println(search);
    }


    public int search(int[] nums, int target) {
        int index = queryIndex(nums, target);
        if (index == -1) {
            return 0;
        }
        int i = index, j = index, k = 0;
        while (i >= 0 && j < nums.length) {
            if (i - 1 > 0 && nums[i - 1] == target) {
                i--;
                k = 1;
            }
            if (j + 1 < nums.length && nums[j + 1] == target) {
                j++;
                k = 1;
            }
            if (k != 1) {
                break;
            }
        }
        return j - i + 1;
    }

    private int queryIndex(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int i = 0;
        int j = nums.length-1;
        while (i <= j) {
            int k = (i + j) / 2;
            if (nums[k] == target) {
                return k;
            }
            if (nums[k] > target) {
                j = k - 1;
            }
            if (nums[k] < target) {
                i = k + 1;
            }
        }
        return -1;
    }
}
