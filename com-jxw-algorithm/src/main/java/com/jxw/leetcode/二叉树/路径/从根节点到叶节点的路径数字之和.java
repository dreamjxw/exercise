/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树.路径;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/5/20 下午11:18
 * @description 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * <p>
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3Etpl5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 从根节点到叶节点的路径数字之和 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return -1;
        }
        process(root, 0);
        return sum;
    }

    private int process(TreeNode root, int num) {
        if (root == null) {
            return -1;
        }
        int temp = num * 10 + root.val;
        int leftTemp = process(root.left, temp);
        int rightTemp = process(root.right, temp);
        if (leftTemp == -1 && rightTemp == -1) {
            sum = sum + temp;
        }
        return num;
    }
}
