/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.everyday;

/**
 * @author jiaxingwu
 * @date 2022/5/15 下午9:46
 * @description 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * <p>
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释:
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/largest-triangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最大三角形面积 {
    public double largestTriangleArea(int[][] points) {
        int cowSize = points.length;
        double result = 0;
        for (int i = 0; i < cowSize; i++) {
            for (int j = i + 1; j < cowSize; j++) {
                for (int k = j + 1; k < cowSize; k++) {
                    result = Math.max(triangleArea(points[i][0], points[i][1], points[j][0], points[j][1],
                            points[k][0], points[k][1]), result);
                }
            }
        }
        return result;
    }

    public double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }
}
