package com.jxw.leetcode.offer;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2021/2/5 17:52
 * @description https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] ints = {1};
        MajorityElement majorityElement = new MajorityElement();
        int i = majorityElement.majorityElement(ints);
        System.out.println(i);

    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
