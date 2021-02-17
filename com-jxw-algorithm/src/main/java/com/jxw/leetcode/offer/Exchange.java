package com.jxw.leetcode.offer;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2021/2/7 20:07
 * @description https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Exchange {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] exchange = new Exchange().exchange(ints);
        System.out.println(Arrays.toString(exchange));
    }

    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            // 找偶数
            while (i < j && nums[i] % 2 != 0) {
                i++;
            }
            // 找奇数
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }
        return nums;
    }
}
