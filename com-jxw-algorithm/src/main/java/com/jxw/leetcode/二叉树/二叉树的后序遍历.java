/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树;

import com.jxw.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    /**
     * 非递归
     */
    public List<Integer> postorderTraversal4Loop(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> help = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 将头节点压入help栈中存储
            TreeNode cur = stack.pop();
            help.push(cur);
            /**
             * 因为stack栈不是打印的那个栈，所以要想help栈中先打印左子树 stack栈中就要先放入左子树，让右子树先进入help栈
             */
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        while (!help.isEmpty()) {
            // 打印
            list.add(help.pop().val);
        }
        return list;
    }
}
