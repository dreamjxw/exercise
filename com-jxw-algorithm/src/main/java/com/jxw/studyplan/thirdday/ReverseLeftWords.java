/*
 * Copyright (C) 2021 dream, Inc. All Rights Reserved.
 */
package com.jxw.studyplan.thirdday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jiaxingwu
 * @date 2022/1/4 下午11:27
 * @description https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class ReverseLeftWords {

    public static void main(String[] args) {
        String abcdefg = new ReverseLeftWords().reverseLeftWords("lrloseumgh", 6);
        System.out.println(abcdefg);
    }

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (n % s.length() == 0) {
            return s;
        }
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.offer(String.valueOf(s.charAt(i)));
        }

        while (n % s.length() != 0) {
            String poll = queue.poll();
            queue.offer(poll);
            --n;
        }
        StringBuilder str = new StringBuilder();
        while (!queue.isEmpty()) {
            str.append(queue.poll());
        }
        return str.toString();
    }
}
