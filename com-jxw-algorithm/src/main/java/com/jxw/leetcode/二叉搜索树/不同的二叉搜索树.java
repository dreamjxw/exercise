/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.二叉搜索树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaxingwu
 * @date 2022/5/26 下午3:01
 * @description 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class 不同的二叉搜索树 {
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 1. 对于n  从i开始遍历，左边有i-1个元素组成左子树，右边有n-i个元素组成右子树，则根为i的二叉搜索树有 左子树数*右子树数种情况。
     * 遍历1~n每个节点  累加即可；
     * 2. 用map缓存计算过的次数，提升性能
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // 左树 有i-1个元素
            int leftResult = numTrees(i - 1);
            // 右树 有n-i个元素
            int rightResult = numTrees(n - i);

            count += leftResult * rightResult;
        }
        map.put(n, count);
        return count;
    }


}
