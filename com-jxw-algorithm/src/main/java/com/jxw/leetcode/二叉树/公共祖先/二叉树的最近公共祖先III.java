/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉树.公共祖先;

/**
 * @author jiaxingwu
 * @date 2022/5/21 下午9:06
 * @description 力扣第 1650 题「二叉树的最近公共祖先 III」
 * 给你输入一棵存在于二叉树中的两个节点p和q，请你返回它们的最近公共祖先，这次输入的二叉树节点比较特殊，包含指向父节点的指针：
 */
public class 二叉树的最近公共祖先III {
    // 包含一个指向父节点的指针  其实相当于一个链表
    Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;
        while (a.val != b.val) {
            if (a == null) {
                a = p;
            } else {
                a = a.parent;
            }

            if (b == null) {
                b = q;
            } else {
                b = b.parent;
            }
        }
        return a;
    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node parent;
    }
}


