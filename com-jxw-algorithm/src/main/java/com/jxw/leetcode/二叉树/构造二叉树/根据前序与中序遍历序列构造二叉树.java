/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树.构造二叉树;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/5/18 下午11:34
 * @description 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 根据前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        if (preLeft == preLeft) {
            return new TreeNode(preorder[preLeft]);
        }
        TreeNode treeNode = new TreeNode(preorder[preLeft]);
        int inIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[preLeft] == inorder[i]) {
                inIndex = i;
                break;
            }
        }
        treeNode.left = buildTree(preorder, preLeft + 1, preLeft + inIndex - inLeft,
                inorder, inLeft, inIndex - 1);
        treeNode.right = buildTree(preorder, preLeft + inIndex - inLeft + 1, preRight,
                inorder, inIndex + 1, inRight);
        return treeNode;
    }
}
