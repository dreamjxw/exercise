package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/25 19:55
 * @description https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class IsStraight {

    public boolean isStraight(int[] nums) {
        sort(nums, 0, nums.length - 1);
        int temp = 0, number = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                number++;
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                return false;
            }

            if ((nums[i] + 1) != nums[i + 1]) {
                temp += (nums[i + 1] - nums[i] - 1);
            }
        }
        return (number - temp) >= 0;
    }


    private void sort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left, j = right;
        while (i < j) {
            for (; i < j && nums[j] > nums[left]; j--) {
            }
            for (; i < j && nums[i] <= nums[left]; i++) {
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int temp = nums[left];
        nums[left] = nums[i];
        nums[i] = temp;
        sort(nums, left, i - 1);
        sort(nums, i + 1, right);
    }
}
