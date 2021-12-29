package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/17 23:07
 * @description https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * <p>
 * maxResult=
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] ints = {-2, -1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray = new MaxSubArray().maxSubArray(ints);
        System.out.println(maxSubArray);
    }


    /**
     * result 记录前n项和， 如果result大于0 则累加上当前项，若小于0则丢弃当前result的值，使result=当前数组值。 maxResult记录result中的最大值
     */
    public int maxSubArray(int[] nums) {
        int maxResult = Integer.MIN_VALUE;
        int result = 0;
        for (int num : nums) {
            if (result >= 0) {
                result += num;
            } else {
                result = num;
            }
            maxResult = Math.max(maxResult, result);
        }
        return maxResult;
    }
}