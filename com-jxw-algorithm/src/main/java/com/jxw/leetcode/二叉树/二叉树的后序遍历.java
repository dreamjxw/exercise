/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树;

import com.jxw.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2022/5/11 上午10:36
 * @description do something with this class...
 */
public class 二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        StringBuilder result = new StringBuilder();
        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        postorderTraversal(treeNode.left, list);
        postorderTraversal(treeNode.right, list);
        list.add(treeNode.val);
    }

    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return result.toString();
        }
        serialize(root, result);
        return result.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        serialize(root.left, sb);
        sb.append(root.val);
        serialize(root.right, sb);
    }
}
