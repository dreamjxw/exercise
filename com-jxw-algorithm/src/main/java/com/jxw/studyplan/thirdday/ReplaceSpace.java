/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.studyplan.thirdday;

/**
 * @author jiaxingwu
 * @date 2022/1/4 下午11:23
 * @description https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        String replaceSpace = new ReplaceSpace().replaceSpace(" ");
        System.out.println(replaceSpace);
    }
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.replaceAll(" ","%20");
    }
}
