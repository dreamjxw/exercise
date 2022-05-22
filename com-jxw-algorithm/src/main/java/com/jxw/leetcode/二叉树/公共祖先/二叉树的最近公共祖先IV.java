/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树.公共祖先;

import com.jxw.domain.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiaxingwu
 * @date 2022/5/21 下午9:06
 * @description 题「二叉树的最近公共祖先 IV」：
 * <p>
 * 依然给你输入一棵不含重复值的二叉树，但这次不是给你输入p和q两个节点了，
 * 而是给你输入一个包含若干节点的列表nodes（这些节点都存在于二叉树中），让你算这些节点的最近公共祖先。
 */
public class 二叉树的最近公共祖先IV {
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node.val);
        }
        return process(root, set);
    }

    TreeNode process(TreeNode root, Set<Integer> nodeSet) {
        if (root == null) {
            return null;
        }
        if (nodeSet.contains(root.val)) {
            return root;
        }

        TreeNode leftNode = process(root.left, nodeSet);
        TreeNode rightNode = process(root.right, nodeSet);

        if (leftNode != null && rightNode != null) {
            return root;
        }
        return leftNode == null ? rightNode : leftNode;
    }
}
