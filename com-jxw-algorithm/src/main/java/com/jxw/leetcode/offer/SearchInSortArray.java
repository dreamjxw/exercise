package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/22 18:38
 * @description https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 统计一个数字在排序数组中出现的次数。
 */
public class SearchInSortArray {


    public int search(int[] nums, int target) {
        int i = find(nums, target);
        if (i == -1) {
            return 0;
        }
        int count = 1;
        int j = i, k = i;
        while (++i < nums.length && nums[i] == nums[k]) {
            count++;
        }
        while (--j >= 0 && nums[j] == nums[k]) {
            count++;
        }
        return count;
    }

    private int find(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int i = 0, j = nums.length - 1;
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

    public static void main(String[] args) {

        int[] ints = {2, 2};
        // int search = new SearchInSortArray().search(ints, 3);

        int i = new SearchInSortArray().find(ints, 3);
        System.out.println(i);
        // System.out.println(search);
    }
}
