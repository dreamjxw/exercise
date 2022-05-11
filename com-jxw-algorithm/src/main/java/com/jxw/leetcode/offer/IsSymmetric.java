package com.jxw.leetcode.offer;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2021/2/18 11:19
 * @description https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
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
