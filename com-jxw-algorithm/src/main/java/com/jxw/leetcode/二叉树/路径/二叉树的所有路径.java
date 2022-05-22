/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树.路径;

import com.jxw.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2022/5/20 下午10:44
 * @description 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * https://leetcode.cn/problems/binary-tree-paths/
 */
public class 二叉树的所有路径 {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        process(root, "");
        return result;
    }

    public String process(TreeNode root, String str) {
        if (root == null) {
            return null;
        }
        String temp = str + root.val + "->";
        String processLeft = process(root.left, temp);
        String processRight = process(root.right, temp);

        if (processLeft == null && processRight == null) {
            result.add(str + root.val);
        }
        return str;
    }
}
