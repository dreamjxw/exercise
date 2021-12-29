package com.jxw.leetcode.offer;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2021/2/7 18:45
 * @description https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] ints = {10, 26, 30, 31, 47, 60};
        int[] ints1 = new TwoSum().twoSum(ints, 40);
        System.out.println(Arrays.toString(ints1));
    }


    public int[] twoSum(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i < j && i < nums.length; ) {
            int temp = nums[i] + nums[j];
            if (temp == target) {
                return new int[]{nums[i], nums[j]};
            }
            if (temp > target) {
                j--;
            }
            if (temp < target) {
                i++;
            }

        }
        return null;
    }
}
