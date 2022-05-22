/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树.构造二叉树;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/5/18 下午11:34
 * @description 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return null;
        }
        int maxNumIndex = leftIndex;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (nums[i] > nums[maxNumIndex]) {
                maxNumIndex = i;
            }
        }
        TreeNode treeNode = new TreeNode(nums[maxNumIndex]);
        treeNode.left = constructMaximumBinaryTree(nums, leftIndex, maxNumIndex);
        treeNode.right = constructMaximumBinaryTree(nums, maxNumIndex + 1, rightIndex);
        return treeNode;
    }
}
