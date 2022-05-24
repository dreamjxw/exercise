/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉搜索树;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/5/24 下午12:09
 * @description 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkValidBST(root, null, null);
    }

    private boolean checkValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) {
            return true;
        }
        if (minNode != null && root.val <= minNode.val) {
            return false;
        }
        if (maxNode != null && root.val >= maxNode.val) {
            return false;
        }
        return checkValidBST(root.left, minNode, root) && checkValidBST(root.right, root, maxNode);
    }
}
