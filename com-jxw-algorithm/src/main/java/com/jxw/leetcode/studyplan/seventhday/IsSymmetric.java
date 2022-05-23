/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.studyplan.seventhday;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/1/13 下午11:37
 * @description https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkSymmetric(root.left, root.right);
    }


    private boolean checkSymmetric(TreeNode lTree, TreeNode rTree) {
        if (lTree == null && rTree == null) {
            return true;
        }
        if (lTree == null || rTree == null) {
            return false;
        }
        if (lTree.val != rTree.val) {
            return false;
        }
        return checkSymmetric(lTree.left, rTree.right) && checkSymmetric(lTree.right, rTree.left);
    }
}
