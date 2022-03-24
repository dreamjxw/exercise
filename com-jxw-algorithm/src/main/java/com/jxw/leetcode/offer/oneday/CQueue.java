/*
 * Copyright (C) 2022 dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.offer.oneday;

import java.util.Stack;

/**
 * @author jiaxingwu
 * @date 2022/2/21 下午11:51
 * @description https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class CQueue {
    private Stack<Integer> add;
    private Stack<Integer> del;

    public CQueue() {
        add = new Stack<>();
        del = new Stack<>();
    }

    public void appendTail(int value) {
        add.push(value);
    }

    public int deleteHead() {
        if (!del.empty()) {
            return del.pop();
        }
        while (!add.empty()) {
            del.push(add.pop());
        }
        if (!del.empty()) {
            return del.pop();
        }
        return -1;
    }
}
