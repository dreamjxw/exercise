/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.everyday;

import com.jxw.domain.TreeNode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author jiaxingwu
 * @date 2022/5/13 下午6:17
 * @description 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 序列化和反序列化二叉搜索树 {
    private static final String NUL = "#";
    private static final String SPLIT = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NUL).append(SPLIT);
            return;
        }
        serialize(root.left, sb);
        serialize(root.right, sb);
        sb.append(root.val).append(SPLIT);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        LinkedList<String> list = new LinkedList<String>();
        Collections.addAll(list, data.split(SPLIT));
        return deserialize(list);
    }


    private TreeNode deserialize(LinkedList<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String last = list.removeLast();
        if (last.equals(NUL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(last));
        root.right = deserialize(list);
        root.left = deserialize(list);
        return root;
    }
}
