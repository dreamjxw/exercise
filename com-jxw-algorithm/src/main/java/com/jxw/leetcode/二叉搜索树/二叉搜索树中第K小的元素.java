/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉搜索树;

import com.jxw.domain.TreeNode;

import java.util.Stack;

/**
 * @author jiaxingwu
 * @date 2022/5/23 下午11:08
 * @description 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 */
public class 二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count = 1;
        while (!(root == null && stack.isEmpty())) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (count == k) {
                return pop.val;
            }
            count++;
            root = pop.right;
        }
        return count;
    }
}
