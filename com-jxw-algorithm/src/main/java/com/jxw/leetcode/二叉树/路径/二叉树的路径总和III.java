/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树.路径;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/5/21 下午9:45
 * @description 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的路径总和III {
    int result = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        process(root, targetSum);
        return result;
    }

    // 前序遍历  遍历每个节点
    private void process(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        process(root, 0, targetSum);
        process(root.left, targetSum);
        process(root.right, targetSum);
    }

    // 每个节点生成所有路径
    private void process(TreeNode root, int num, int targetSum) {
        if (root == null) {
            return;
        }
        if (num + root.val == targetSum) {
            result++;
        }
        process(root.left, num + root.val, targetSum);
        process(root.right, num + root.val, targetSum);
    }
}
