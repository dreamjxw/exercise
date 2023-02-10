/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

/**
 * @author jiaxingwu
 * @date 2022/7/12 下午7:28
 * @description 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 * <p>
 * 另有一个二维索引数组 indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 * <p>
 * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 * <p>
 * ri 行上的所有单元格，加 1 。
 * ci 列上的所有单元格，加 1 。
 * 给你 m、n 和 indices 。请你在执行完所有 indices 指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 奇数值单元格的数目 {
    public int oddCells(int m, int n, int[][] indices) {
        int result = 0;
        int[][] data = new int[m][n];
        for (int[] index : indices) {
            int x = index[0];
            int y = index[1];
            int k = 0;
            while (k < n) {
                data[x][k] += 1;
                k++;
            }
            k = 0;
            while (k < m) {
                data[k][y] += 1;
                k++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] % 2 == 1) {
                    result++;
                }
            }
        }

        return result;
    }
}
