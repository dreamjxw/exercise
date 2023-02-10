/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

import com.jxw.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author jiaxingwu
 * @date 2022/6/22 下午10:18
 * @description 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 */
public class 找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            list.clear();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return list.get(0);
    }
}
