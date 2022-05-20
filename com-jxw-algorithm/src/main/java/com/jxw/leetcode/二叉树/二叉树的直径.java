/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/5/15 上午12:35
 * @description 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 *  
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的直径 {
    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return result;
    }

    private int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int diameterLeft = diameter(root.left);
        int diameterRight = diameter(root.right);
        int temp = diameterLeft + diameterRight;
        result = Math.max(temp, result);
        // 直径  即二叉树左右子树最大深度之和，所以这里返回最大深度，+1即包含当前节点
        return 1 + Math.max(diameterLeft, diameterRight);
    }
}
