package com.jxw.leetcode.zero2ten;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaxingwu
 * @date 2019/8/6 10:53
 * @Description 第一题 两数之和
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {1, 3, 5, 7, 9};
        twoSum.sum(nums, 4);
    }

    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] sum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
