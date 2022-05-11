/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.studyplan.sixthday;

import com.jxw.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author jiaxingwu
 * @date 2022/1/12 下午11:20
 * @description https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
public class LevelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        // 标志   遇到就该下一层了
        TreeNode node = new TreeNode(-1);
        deque.offer(node);

        List<Integer> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll == node) {
                result.add(list);
                list = new ArrayList<>();
                if (deque.peek() != null) {
                    deque.offer(node);
                }
                continue;
            }
            list.add(poll.val);
            root = poll;
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
