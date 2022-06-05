/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2022/6/1 下午11:19
 * @description 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断
 * 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 * <p>
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/matchsticks-to-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 火柴拼正方形 {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum = sum + matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int avg = sum / 4;
        Arrays.sort(matchsticks);
        return allocate(matchsticks, matchsticks.length - 1, new int[4], avg);
    }

    private boolean allocate(int[] nums, int pos, int[] sums, int avg) {
        if (pos == -1)
            return sums[0] == avg && sums[1] == avg && sums[2] == avg;
        for (int i = 0; i < 4; ++i) {
            if (sums[i] + nums[pos] > avg) continue;
            sums[i] += nums[pos];
            if (allocate(nums, pos - 1, sums, avg))
                return true;
            sums[i] -= nums[pos];
        }
        return false;
    }
}
