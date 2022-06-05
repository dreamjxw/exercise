/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/5/31 下午11:33
 * @description 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * <p>
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 从根到叶的二进制数之和 {
    int result = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        process(root, 0);
        return result;
    }

    private void process(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        int temp = val << 1 | root.val;
        if (root.left == null && root.right == null) {
            result += temp;
            return;
        }
        process(root.left, temp);
        process(root.right, temp);
    }
}
