/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

/**
 * @author jiaxingwu
 * @date 2022/6/7 下午10:59
 * @description 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路分析：
 * <p>
 * 根据题意可以知道：珂珂吃香蕉的速度越小，耗时越多。反之，速度越大，耗时越少，这是题目的 单调性；
 * 我们要找的是速度。因为题目限制了珂珂一个小时之内只能选择一堆香蕉吃，因此速度最大值就是这几堆香蕉中，数量最多的那一堆。速度的最小值是 11，其实还可以再分析一下下界是多少，由于二分搜索的时间复杂度很低，严格的分析不是很有必要；
 * 还是因为珂珂一个小时之内只能选择一堆香蕉吃，因此：每堆香蕉吃完的耗时 = 这堆香蕉的数量 / 珂珂一小时吃香蕉的数量。根据题意，这里的 / 在不能整除的时候，需要 上取整。
 */
public class 爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (this.process(piles, mid) > h) {
                // 吃的太慢
                left = mid + 1;
            } else {
                // 吃的太快
                right = mid;
            }
        }
        return left;
    }

    private int process(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile % speed == 0 ? pile / speed : ((pile / speed) + 1));
        }
        return sum;
    }
}
