package com.jxw.leetcode.offer;

import java.util.Stack;

/**
 * @author jiaxingwu
 * @date 2021/1/6 19:03
 * @description https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 */
public class CQueue {
    private Stack<Integer> addList;
    private Stack<Integer> delList;


    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        int i = cQueue.deleteHead();
        int i1 = cQueue.deleteHead();
        System.out.println(1);
    }

    public CQueue() {
        addList = new Stack<>();
        delList = new Stack<>();
    }

    public void appendTail(int value) {
        addList.push(value);
    }

    public int deleteHead() {
        if (delList.size() != 0) {
            return delList.pop();
        }
        while (addList.size() != 0) {
            delList.push(addList.pop());
        }

        if (delList.size() == 0) {
            return -1;
        }
        return delList.pop();
    }
}