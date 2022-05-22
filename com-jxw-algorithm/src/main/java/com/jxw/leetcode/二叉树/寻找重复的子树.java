/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树;

import com.jxw.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiaxingwu
 * @date 2022/5/20 下午3:52
 * @description 给定一棵二叉树 root，返回所有重复的子树。
 * <p>
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 寻找重复的子树 {
    List<TreeNode> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findDuplicateSubtree(root);
        return result;
    }

    private String findDuplicateSubtree(TreeNode root) {
        if (root == null) {
            return null;
        }
        String builder = root.val + "," + findDuplicateSubtree(root.left) + "," + findDuplicateSubtree(root.right);
        Integer count = map.get(builder);
        if (count == null) {
            map.put(builder, 1);
        } else {
            if (count == 1) {
                result.add(root);
            }
            map.put(builder, count + 1);
        }
        return builder;
    }
}
