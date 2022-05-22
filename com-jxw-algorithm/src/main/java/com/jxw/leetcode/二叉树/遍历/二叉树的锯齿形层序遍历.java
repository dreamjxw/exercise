/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树.遍历;

import com.jxw.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jiaxingwu
 * @date 2022/5/21 下午10:01
 * @description do something with this class...
 */
public class 二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        LinkedList<Integer> list;
        boolean flag = false;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            list = new LinkedList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }
}
