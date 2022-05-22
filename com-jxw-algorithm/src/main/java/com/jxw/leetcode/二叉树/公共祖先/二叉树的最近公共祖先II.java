/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树.公共祖先;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/5/21 下午9:06
 * @description 力扣第 1644 题「二叉树的最近公共祖先 II」：
 * <p>
 * 给你输入一棵不含重复值的二叉树的，以及两个节点p和q，如果p或q不存在于树中，则返回空指针，
 * 否则的话返回p和q的最近公共祖先节点。
 */
public class 二叉树的最近公共祖先II {
    boolean leftFlag = false;
    boolean rightFlag = false;

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode process = process(root, p, q);
        return leftFlag && rightFlag ? process : null;
    }

    // p  q 都找到才行    找不到不行
    TreeNode process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode leftTreeNode = process(root.left, p, q);
        TreeNode rightTreeNode = process(root.right, p, q);
        // 要变理完整个树  所以放在后序的位置
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        // 左子树找到了   打标
        if (leftTreeNode != null) {
            leftFlag = true;
        }

        // 右子树找到了   打标
        if (rightTreeNode != null) {
            rightFlag = true;
        }

        // 左右子树都找到了   返回root节点
        if (leftTreeNode != null && rightTreeNode != null) {
            return root;
        }
        // 谁不为空接着找谁
        return leftTreeNode == null ? rightTreeNode : leftTreeNode;
    }
}
