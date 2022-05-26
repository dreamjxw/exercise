/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉搜索树;

import com.jxw.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2022/5/26 下午4:31
 * @description 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
public class 不同的二叉搜索树II {
    public List<TreeNode> generateTrees(int n) {
        return generateTree(1, n);
    }

    /**
     * 1. 遍历每一个值作为根节点
     * 2. 找出左右子树的所有可能性
     * 3. 根据根节点和左右子树 构建所有的树结构
     */
    public List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> temp = new ArrayList<>();
        if (start > end) {
            temp.add(null);
            return temp;
        }
        if (start == end) {
            temp.add(new TreeNode(start));
            return temp;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generateTree(start, i - 1);
            List<TreeNode> rightTree = generateTree(i + 1, end);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    temp.add(treeNode);
                }
            }
        }
        return temp;
    }
}
