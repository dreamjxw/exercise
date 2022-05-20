/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/5/18 下午11:47
 * @description 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        if (postLeft > postRight) {
            return null;
        }
        if (postLeft == postRight) {
            return new TreeNode(postorder[postLeft]);
        }
        TreeNode treeNode = new TreeNode(postorder[postRight]);
        int inIndex = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (postorder[postRight] == inorder[i]) {
                inIndex = i;
                break;
            }
        }

        treeNode.left = buildTree(inorder, inLeft, inIndex - 1,
                postorder, postLeft, postLeft + inIndex - inLeft - 1);
        treeNode.right = buildTree(inorder, inIndex + 1, inRight,
                postorder, postLeft + inIndex - inLeft, postRight - 1);
        return treeNode;
    }
}
