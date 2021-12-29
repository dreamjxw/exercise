package com.jxw.domain;

/**
 * @author jiaxingwu
 * @date 2020/5/18 15:55
 * @Description
 */
public class Tree {
    private Integer value;
    private Tree lChild;
    private Tree rChild;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Tree getlChild() {
        return lChild;
    }

    public void setlChild(Tree lChild) {
        this.lChild = lChild;
    }

    public Tree getrChild() {
        return rChild;
    }

    public void setrChild(Tree rChild) {
        this.rChild = rChild;
    }
}
