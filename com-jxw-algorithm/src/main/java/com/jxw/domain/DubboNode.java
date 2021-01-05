package com.jxw.domain;

/**
 * @author jiaxingwu
 * @date 2020/5/20 15:57
 * @Description 双向链表
 */
public class DubboNode {
    private Integer value;
    private DubboNode preNode;
    private DubboNode nextNode;

    public DubboNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public DubboNode getPreNode() {
        return preNode;
    }

    public void setPreNode(DubboNode preNode) {
        this.preNode = preNode;
    }

    public DubboNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DubboNode nextNode) {
        this.nextNode = nextNode;
    }
}
