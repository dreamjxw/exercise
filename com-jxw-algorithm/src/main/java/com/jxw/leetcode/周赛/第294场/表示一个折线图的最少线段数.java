/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.周赛.第294场;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2022/5/23 上午11:18
 * @description 给你一个二维整数数组 stockPrices ，其中 stockPrices[i] = [dayi,
 * pricei] 表示股票在 dayi 的价格为 pricei 。折线图 是一个二维平面上的若干个点组成的图，横坐标表示日期，纵坐标表示价格，折线图由相邻的点连接而成。比方说下图是一个例子：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-lines-to-represent-a-line-chart
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 表示一个折线图的最少线段数 {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length <= 1) {
            return 0;
        }
        Arrays.sort(stockPrices, (e1, e2) -> (e1[0] == e2[0] ? (e1[1] - e2[1]) : (e1[0] - e2[0])));
        BigDecimal temp = new BigDecimal(0);
        int count = 0;
        for (int i = 1; i < stockPrices.length; i++) {
            int x1 = stockPrices[i - 1][0];
            int y1 = stockPrices[i - 1][1];
            int x2 = stockPrices[i][0];
            int y2 = stockPrices[i][1];
            BigDecimal copyTemp = new BigDecimal(y1 - y2).divide(new BigDecimal(x1 - x2), 50,
                    BigDecimal.ROUND_HALF_UP);
            if (!temp.equals(copyTemp)) {
                count++;
                temp = copyTemp;
            }
        }
        return count;
    }
}
