package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/1/4 18:45
 * @description https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        // 右上开始
        int x = 0, y = col - 1;
        // 左下开始
        int i = row - 1, j = 0;
        while (i >= 0 && j < col && x < row && y >= 0) {
            if (matrix[i][j] == target || matrix[x][y] == target) {
                return true;
            }
            int flag = 0;
            if (matrix[x][y] < target) {
                flag = 1;
            }

            if (matrix[x][y] > target) {
                flag = 2;
            }

            if (matrix[i][j] < target) {
                flag = 3;
            }

            if (matrix[i][j] > target) {
                flag = 4;
            }

            if (flag == 1) {
                x++;
            }
            if (flag == 2) {
                y--;
            }
            if (flag == 3) {
                j++;
            }
            if (flag == 4) {
                i--;
            }
        }
        return false;
    }
}
