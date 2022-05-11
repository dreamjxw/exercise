package com.jxw.leetcode.offer;

import com.jxw.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2021/2/3 21:01
 * @description https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * <p>
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class KthLargest {
    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        rSort(root, list, k);
        return list.get(k - 1);
    }

    private void rSort(TreeNode root, List<Integer> data, int k) {
        if (root == null || data.size() >= k) {
            return;
        }
        rSort(root.right, data, k);
        data.add(root.val);
        rSort(root.left, data, k);
    }
}
