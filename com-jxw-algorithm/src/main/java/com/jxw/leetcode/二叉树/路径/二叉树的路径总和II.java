/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树.路径;

import com.jxw.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2022/5/21 下午9:41
 * @description 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的路径总和II {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        process(root, target, new ArrayList());
        return result;
    }

    public List<Integer> process(TreeNode root, int target, List<Integer> list) {
        if (root == null) {
            return null;
        }
        List<Integer> tempResult = new ArrayList(list);
        tempResult.add(root.val);
        List<Integer> leftResult = process(root.left, target - root.val, tempResult);
        List<Integer> rightResult = process(root.right, target - root.val, tempResult);

        if (leftResult == null && rightResult == null && target == root.val) {
            result.add(tempResult);
        }
        return tempResult;
    }
}
