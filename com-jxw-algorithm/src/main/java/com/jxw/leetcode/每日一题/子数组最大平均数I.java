package com.jxw.leetcode.每日一题;

/**
 * @author jiaxingwu
 * @date 2021/2/4 10:37
 * @description
 */
public class 子数组最大平均数I {

    public static void main(String[] args) {
        int[] ints = {1, 12, -5, -6, 50, 3};

        子数组最大平均数I 子数组最大平均数I = new 子数组最大平均数I();
        double maxAverage = 子数组最大平均数I.findMaxAverage(ints, 4);
        System.out.println(maxAverage);
    }

    public double findMaxAverage(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += nums[i];
        }

        int j = 0;
        double max = count;
        for (int i = k; i < nums.length; i++, j++) {
            count = count + nums[i] - nums[j];
            max = Math.max(max, count);
        }
        return max / k;
    }
}
