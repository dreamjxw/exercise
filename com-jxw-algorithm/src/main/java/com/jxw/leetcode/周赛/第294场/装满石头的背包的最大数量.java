/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.周赛.第294场;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2022/5/23 上午11:17
 * @description 现有编号从 0 到 n - 1 的 n 个背包。给你两个下标从 0 开始的整数数组 capacity 和 rocks 。第 i 个背包最大可以装 capacity[i] 块石头，当前已经装了
 * rocks[i] 块石头。另给你一个整数 additionalRocks ，表示你可以放置的额外石头数量，石头可以往 任意 背包中放置。
 * <p>
 * 请你将额外的石头放入一些背包中，并返回放置后装满石头的背包的 最大 数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-bags-with-full-capacity-of-rocks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 装满石头的背包的最大数量 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] data = new int[capacity.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(data);
        int count = 0;
        for (int datum : data) {
            if (datum <= additionalRocks) {
                count++;
            }
            if (datum > additionalRocks) {
                break;
            }
            additionalRocks -= datum;
        }
        return count;
    }
}
