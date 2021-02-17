package com.jxw.leetcode.everyday;

/**
 * @author jiaxingwu
 * @date 2021/2/7 17:09
 * @description https://leetcode-cn.com/problems/non-decreasing-array/
 * <p>
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 */
public class 非递减数列 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 5, 3};
        boolean b = new 非递减数列().checkPossibility(ints);
        System.out.println(b);
    }

    public boolean checkPossibility(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = i + 2;
                if (temp < nums.length && nums[i] > nums[temp]) {
                    nums[i] = nums[i + 1];
                } else {
                    nums[i + 1] = nums[i];
                }

                flag = true;
                break;
            }
        }
        if (!flag) {
            return true;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
