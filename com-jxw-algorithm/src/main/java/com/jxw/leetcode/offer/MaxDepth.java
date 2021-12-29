package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/3 16:49
 * @description https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class MaxDepth {

    /**
     * 分别求左子树 和右子数深度，然后求最大值
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);

        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
