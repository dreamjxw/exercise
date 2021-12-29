package com.jxw.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiaxingwu
 * @date 2021/1/4 17:11
 * @description https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * <p>
 * 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(findRepeatNumber(a));
    }

    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[nums[i]];
            nums[temp] = temp;
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int data : nums) {
            if (set.contains(data)) {
                return data;
            }
            set.add(data);
        }

        return -1;
    }
}
