/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉搜索树;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/5/24 下午12:44
 * @description do something with this class...
 */
public class 二叉搜索树中节点删除 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 右子树中找到最小的元素  or   左子树中找到最大的元素
            TreeNode temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            root.val = temp.val;
            // 右树中删除该节点
            root.right = deleteNode(root.right, temp.val);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }
}
