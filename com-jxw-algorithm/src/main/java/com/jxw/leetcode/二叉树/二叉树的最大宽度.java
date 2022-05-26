/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树;

import com.jxw.domain.TreeNode;

import java.util.LinkedList;

/**
 * @author jiaxingwu
 * @date 2022/5/26 下午12:03
 * @description 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的最大宽度 {
    /**
     * 对于一颗完全二叉树，如果按照从上至下，从左往右对所有节点从零开始顺序编号
     * 则父节点的左孩子节点的序号：2i+1 父节点的右孩子节点的序号：2i+2;
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        root.val = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int index = queue.getLast().val - queue.getFirst().val + 1;
            for (int i = 0; i < queueSize; i++) {
                TreeNode pop = queue.poll();
                if (pop.left != null) {
                    queue.offer(pop.left);
                    // 左子树2n+1
                    pop.left.val = pop.val * 2 + 1;
                }
                if (pop.right != null) {
                    queue.offer(pop.right);
                    // 右子树2n+2
                    pop.right.val = pop.val * 2 + 2;
                }
            }
            max = Math.max(max, index);
        }
        return max;
    }
}
