package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/22 18:38
 * @description https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 统计一个数字在排序数组中出现的次数。
 */
public class SearchInSortArray {

    public static void main(String[] args) {

        int[] ints = {2, 2};
        int search = new SearchInSortArray().search(ints, 3);
        System.out.println(search);
    }


    public int search(int[] nums, int target) {
        int i = find(nums, target);
        if (i == -1) {
            return 0;
        }
        int count = 1;
        int j = i, k = i;
        while (--j >= 0 && ++i < nums.length) {
            if (nums[k] == nums[i]) {
                count++;
            }
            if (nums[k] == nums[j]) {
                count++;
            }
            if (nums[i] != nums[k] && nums[j] != nums[k]) {
                break;
            }
        }
        return count;
    }

    private int find(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int i = 0, j = nums.length;
        while (i <= j) {
            int flag = (i + j) / 2;
            if (nums[flag] == target) {
                return flag;
            }
            if (nums[flag] < target) {
                i = flag + 1;
            }
            if (nums[flag] > target) {
                j = flag - 1;
            }
        }
        return -1;
    }
}
