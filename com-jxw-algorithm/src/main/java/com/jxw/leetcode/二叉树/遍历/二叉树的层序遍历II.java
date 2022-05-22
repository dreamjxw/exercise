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
 * @date 2022/5/21 下午9:58
 * @description 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class 二叉树的层序遍历II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> resultList = new LinkedList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> list;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            list = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            resultList.addFirst(list);
        }
        return resultList;
    }
}
