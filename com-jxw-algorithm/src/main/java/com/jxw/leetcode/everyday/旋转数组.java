package com.jxw.leetcode.everyday;

/**
 * @author jiaxingwu
 * @date 2021/1/8 20:21
 * @description https://leetcode-cn.com/problems/rotate-array/
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * <p>
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class 旋转数组 {
    public static void main(String[] args) {

    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rotate(nums, k, 0);

    }

    private void rotate(int[] nums, int k, int index) {
        int temp = index + k;
        if (k >= nums.length) {
            temp = temp - nums.length;
        }
        if (temp == index) {
            return;
        }
        int flag = nums[temp];
        nums[temp] = nums[index];

        rotate(nums, k, temp);
    }
}
