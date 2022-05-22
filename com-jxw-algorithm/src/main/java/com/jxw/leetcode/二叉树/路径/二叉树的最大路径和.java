/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树.路径;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/5/21 下午9:44
 * @description 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的最大路径和 {
    int result = -1001;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        process(root, 0);
        return result;
    }

    private int process(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        int leftResult = process(root.left, num);
        int rightResult = process(root.right, num);
        // 根节点   根+左  根+右   取最大值。  并将结果返回上一级
        int temp = Math.max(root.val, Math.max(root.val + leftResult, root.val + rightResult));
        // 左节点+右节点+根  根节点   根+左  根+右  现有最大值    求最大值。
        result = Math.max(Math.max(temp, root.val + leftResult + rightResult), result);
        return temp;
    }
}
