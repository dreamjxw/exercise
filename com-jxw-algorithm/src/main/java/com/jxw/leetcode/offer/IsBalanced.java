package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/17 23:36
 * @description https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(treeHeap(root.left) - treeHeap(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;

    }


    private int treeHeap(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int leftHeap = treeHeap(treeNode.left);
        int rightHeap = treeHeap(treeNode.right);
        return Math.max(leftHeap, rightHeap) + 1;
    }
}
