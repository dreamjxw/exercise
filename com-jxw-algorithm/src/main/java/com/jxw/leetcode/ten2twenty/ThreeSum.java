package com.jxw.leetcode.ten2twenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2019/8/12 20:16
 * @Description 第十五题 三数之和
 * 首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，计算三个数的和 sumsum     判断是否满足为 00，满足则添加进结果集
 * 如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
 * 如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
 * 当 sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++L++
 * 当 sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R--R−−
 * 时间复杂度：O(n^2)
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {2, 0, -2, -5, -5, -3, 2, -4};
        ThreeSum threeSum = new ThreeSum();
        Arrays.sort(nums);
        System.out.println(threeSum.threeSum(nums));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        int length = nums.length;
        if (nums == null || length < 3) {
            return resultList;
        }
        Arrays.sort(nums);
        int count, l, r;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            l = i + 1;
            r = length - 1;
            while (l < r) {
                count = nums[i] + nums[l] + nums[r];
                if (count == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (count > 0) {
                    r--;
                } else if (count < 0) {
                    l++;
                }
            }
        }
        return resultList;
    }

}
