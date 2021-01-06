package com.jxw.leetcode.offer;


/**
 * @author jiaxingwu
 * @date 2021/1/5 16:41
 * @description https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 */
public class BuildTree {
    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] preOrder = new int[5];
        preOrder[0] = 3;
        preOrder[1] = 9;
        preOrder[2] = 20;
        preOrder[3] = 15;
        preOrder[4] = 7;
        int[] inOrder = new int[5];
        inOrder[0] = 9;
        inOrder[1] = 3;
        inOrder[2] = 15;
        inOrder[3] = 20;
        inOrder[4] = 7;
        TreeNode treeNode = buildTree.buildTree(preOrder, inOrder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }


    private TreeNode buildTree(int[] preorder, int[] inorder, int pIndex, int inLeft, int inRight) {
        if (inLeft > inRight || pIndex > preorder.length - 1) {
            return null;
        }
        int node = preorder[pIndex];
        TreeNode treeNode = new TreeNode(node);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == node) {
                index = i;
                pIndex++;
                break;
            }
        }
        treeNode.left = buildTree(preorder, inorder, pIndex, inLeft, index - 1);
        treeNode.right = buildTree(preorder, inorder, pIndex + (index - inLeft), index + 1, inRight);
        return treeNode;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
