/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.studyplan.fifthday;

/**
 * @author jiaxingwu
 * @date 2022/1/12 下午4:25
 * @description https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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
        if (matrix.length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1, k = matrix.length - 1, l = 0;
        while ((i < matrix.length && j >= 0) || (l < matrix[0].length && k >= 0)) {
            if (i < matrix.length && j >= 0) {
                int temp = matrix[i][j];
                if (temp == target) {
                    return true;
                }
                if (temp > target) {
                    j--;
                } else {
                    i++;
                }
            }

            if (l < matrix[0].length && k >= 0) {
                int temp = matrix[k][l];
                if (temp == target) {
                    return true;
                }
                if (temp > target) {
                    k--;
                } else {
                    l++;
                }
            }
        }
        return false;
    }
}
