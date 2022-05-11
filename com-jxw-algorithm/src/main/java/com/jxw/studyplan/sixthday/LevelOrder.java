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
 * @date 2022/1/12 下午10:40
 * @description https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.val);
            root = poll;
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }

        int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
