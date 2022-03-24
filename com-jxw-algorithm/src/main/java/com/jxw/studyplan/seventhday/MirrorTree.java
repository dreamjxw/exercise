/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.studyplan.seventhday;

import com.jxw.leetcode.offer.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/1/13 下午11:25
 * @description https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class MirrorTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode = mirrorTree(treeNode1);
    }


    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode leftNode = mirrorTree(root.right);
        TreeNode rightNode = mirrorTree(root.left);

        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
