package com.jxw.domain;

/**
 * @author jiaxingwu
 * @date 2020/5/18 16:12
 * @Description 单向链表
 */
public class SignNode {
    private int value;
    private SignNode next;

    public SignNode(int x) {
        value = x;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SignNode getNext() {
        return next;
    }

    public void setNext(SignNode next) {
        this.next = next;
    }
}
