package com.jxw.leetcode.studyplan.firstday;

import java.util.Stack;

/**
 * @author jiaxingwu
 * @date 2021/12/29 下午10:54
 * @description https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
class MinStack {
    private Stack<Integer> stack;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.empty()) {
            min = x;
        } else {
            if (x < min) {
                min = x;
            }
        }
        stack.push(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop > min) {
            return;
        }
        if (stack.empty()) {
            return;
        }
        min = stack.peek();
        for (Integer integer : stack) {
            if (integer < min) {
                min = integer;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */