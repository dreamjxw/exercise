package com.jxw.leetcode.everyday;

/**
 * @author jiaxingwu
 * @date 2021/2/22 14:29
 * @description https://leetcode-cn.com/problems/toeplitz-matrix/
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * <p>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 */
public class 托普利茨矩阵 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        if (row == 1 || col == 1) {
            return true;
        }
        int i = 0, j = col - 1;
        while (i < row) {
            if (!check(matrix, i, j)) {
                return false;
            }
            if (j != 0) {
                j--;
                continue;
            }
            if (j == 0) {
                i++;
            }
        }
        return true;
    }


    private boolean check(int[][] matrix, int i, int j) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return true;
        }
        int temp = matrix[i][j];

        while (i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] != temp) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
