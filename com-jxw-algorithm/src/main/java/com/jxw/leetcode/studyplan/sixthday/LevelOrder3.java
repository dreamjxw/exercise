/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.studyplan.sixthday;

import com.jxw.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jiaxingwu
 * @date 2022/1/12 下午11:35
 * @description https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class LevelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Queue<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        TreeNode node = new TreeNode(-1);
        deque.offer(node);
        int flag = 1;
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll == node) {
                result.add(list);
                list = new LinkedList<>();
                if (deque.peek() != null) {
                    deque.offer(node);
                }
                flag++;
                continue;
            }
            root = poll;
            if (flag % 2 == 0) {
                list.addFirst(poll.val);
            } else {
                list.addLast(poll.val);
            }

            if (root.left != null) {
                deque.offer(root.left);
            }
            if (root.right != null) {
                deque.offer(root.right);
            }
        }
        return result;
    }
}
