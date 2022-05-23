package com.jxw.leetcode.studyplan.firstday;

import java.util.Stack;

/**
 * @author jiaxingwu
 * @date 2021/12/29 下午10:44
 * @description https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class CQueue {
    private Stack<Integer> addStack;
    private Stack<Integer> delStack;

    public CQueue() {
        addStack = new Stack<>();
        delStack = new Stack<>();
    }

    public void appendTail(int value) {
        addStack.push(value);
    }

    public int deleteHead() {
        if (!delStack.empty()) {
            return delStack.pop();
        }
        while (!addStack.empty()) {
            delStack.push(addStack.pop());
        }
        if (delStack.empty()) {
            return -1;
        }
        return delStack.pop();
    }
}
