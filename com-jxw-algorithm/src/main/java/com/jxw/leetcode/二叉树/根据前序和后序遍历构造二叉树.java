/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/5/19 下午4:22
 * @description 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 * <p>
 * 如果存在多个答案，您可以返回其中 任何 一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 根据前序和后序遍历构造二叉树 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePost(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }


    private TreeNode constructFromPrePost(int[] preorder, int preStart, int preEnd,
                                          int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // 加上这个 若有左右子树走在一起了，那么当前节点直接返回，否则可能造成数组下标越界
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int postIndex = postStart;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorder[i] == preorder[preStart + 1]) {
                postIndex = i;
                break;
            }
        }
        int leftLength = postIndex - postStart + 1;
        root.left = constructFromPrePost(preorder, preStart + 1, preStart + leftLength,
                postorder, postStart, postIndex);
        root.right = constructFromPrePost(preorder, preStart + leftLength + 1, preEnd,
                postorder, postIndex + 1, postEnd - 1);
        return root;
    }
}
