package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/3 16:11
 * @description https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode lTree = mirrorTree(root.right);
        TreeNode rTree = mirrorTree(root.left);

        root.left = lTree;
        root.right = rTree;

        return root;
    }
}
