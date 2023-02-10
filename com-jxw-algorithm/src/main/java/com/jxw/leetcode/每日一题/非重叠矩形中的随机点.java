/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

import java.util.Random;

/**
 * @author jiaxingwu
 * @date 2022/6/9 下午10:37
 * @description do something with this class...
 */
public class 非重叠矩形中的随机点 {
    int[][] data;
    Random random = new Random();

    public 非重叠矩形中的随机点(int[][] rects) {
        data = rects;
    }

    public int[] pick() {
        int index = 0;
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            int x2 = data[i][2];
            int x1 = data[i][0];
            int y2 = data[i][3];
            int y1 = data[i][1];
            int count = (x2 - x1) / (y2 - y1);
            sum += count;
            if (random.nextInt(sum) < count) {
                index = i;
            }

        }
        int x1 = data[index][0];
        int x2 = data[index][2];
        int y1 = data[index][1];
        int y2 = data[index][3];

        int x = random.nextInt(x2 - x1 + 1) + x1;
        int y = random.nextInt(y2 - y1 + 1) + y1;

        return new int[]{x, y};
    }
}
