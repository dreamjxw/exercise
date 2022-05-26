/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉搜索树;

import com.jxw.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2022/5/26 下午5:28
 * @description 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 * https://leetcode.cn/problems/recover-binary-search-tree/
 */
public class 恢复二叉搜索树 {
    /**
     * 1. 中序遍历
     * 2. 找到需要交换的两个元素
     * 3，再次遍历删除掉
     */
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        loop(root, list);

        int first = 0;
        int second = 0;
        boolean temp = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) < list.get(i)) {
                if (temp) {
                    first = list.get(i + 1);
                    second = list.get(i);
                    temp = false;
                } else {
                    first = list.get(i + 1);
                    break;
                }
            }
        }

        repact(root, first, second);
    }


    private void loop(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        loop(root.left, list);
        list.add(root.val);
        loop(root.right, list);
    }

    private void repact(TreeNode root, int first, int second) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (val == first) {
            root.val = second;
        }
        if (val == second) {
            root.val = first;
        }
        repact(root.left, first, second);
        repact(root.right, first, second);
    }
}
