package com.jxw.leetcode.ten2twenty;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2019/8/22 18:15
 * @Description 第十六题   最接近的三数之和
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {1, 1, 1, 0};
        int target = -100;
        System.out.println(threeSumClosest.threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        if (nums.length < 3) return 0;
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        if (nums[0] + nums[1] + nums[2] > target) return nums[0] + nums[1] + nums[2];
        int count, l, r, temp = Integer.MAX_VALUE, min = 0;
        for (int i = 0; i < length; i++) {
            l = i + 1;
            r = length - 1;
            if (i > 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (l < r) {
                count = nums[i] + nums[l] + nums[r] - target;
                if (count == 0) {
                    return target;
                }
                if (Math.abs(temp) > Math.abs(count)) {
                    temp = count;
                    min = nums[i] + nums[l] + nums[r];
                }
                if (count > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return min;
    }
}
