/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树.公共祖先;

import com.jxw.domain.TreeNode;

/**
 * @author jiaxingwu
 * @date 2022/5/20 下午5:47
 * @description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 找到一个  就把当前节点返回。都找到的情况在下面返回
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftProcess = lowestCommonAncestor(root.left, p, q);
        TreeNode rightProcess = lowestCommonAncestor(root.right, p, q);
        // 左右都找到 返回root
        if (leftProcess != null && rightProcess != null) {
            return root;
        }
        return leftProcess == null ? rightProcess : leftProcess;
    }

    //公司技术部出了两个叛徒，技术部的每个小部门都有两个部门（二叉树）要找出他们的Line Manager
    //各单位开始排查，从基层员工查起，最后汇总，找第一个Line manager
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        //我自己是叛徒之一，但是我不一定受到惩罚，因为要找的是叛徒的老板，但是你代表你的团队找到了一个叛徒
        if (root == p || root == q) return root;
        //在各层级团队找叛徒
        TreeNode first_traitor = lowestCommonAncestor1(root.left, p, q);
        //在各层级团队找叛徒
        TreeNode second_traitor = lowestCommonAncestor1(root.right, p, q);

        //我们团队找到两叛徒了，game over,倒霉的就是我。接下去我会被一层一层的往上提交，最后到老板那。
        if (first_traitor != null && second_traitor != null) {
            return root;
        }
        //我们团队只找到一个叛徒，这个叛徒代表整个团队，就用这个叛徒来向上（回溯）提交甩锅
        //p.s. 太好了，跟我这个小manager没啥关系
        if (first_traitor != null) return first_traitor;
        if (second_traitor != null) return second_traitor;

        //我们是最干净的团队！
        return null;
    }
}
