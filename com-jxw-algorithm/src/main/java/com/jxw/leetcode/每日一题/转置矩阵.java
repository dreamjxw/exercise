package com.jxw.leetcode.每日一题;

/**
 * @author jiaxingwu
 * @date 2021/2/25 18:42
 * @description https://leetcode-cn.com/problems/transpose-matrix/
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * <p>
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 */
public class 转置矩阵 {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return matrix;
        }
        int col = matrix[0].length;
        int[][] result = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[j][i] =matrix[i][j];
            }
        }
        return result;
    }
}
