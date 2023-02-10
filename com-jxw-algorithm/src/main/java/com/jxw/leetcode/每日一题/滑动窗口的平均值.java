/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

import java.util.ArrayList;

/**
 * @author jiaxingwu
 * @date 2022/7/18 下午10:45
 * @description 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 * <p>
 * 实现 MovingAverage 类：
 * <p>
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/qIsx9U
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 滑动窗口的平均值 {
}

class MovingAverage {
    ArrayList<Integer> list;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        list = new ArrayList<>();
        this.size = size;
    }

    public double next(int val) {
        list.add(val);
        int temp = 0;
        for (int i = 0; i < size && list.size() >= 1 + i; i++) {
            temp += list.get(list.size() - 1 - i);
        }
        return (double) temp / (double) val;
    }
}
