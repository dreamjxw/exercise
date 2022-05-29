/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

/**
 * @author jiaxingwu
 * @date 2022/5/28 上午12:02
 * @description 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-closest-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 单词距离 {
    public int findClosest(String[] words, String word1, String word2) {
        int result = words.length;
        int iFirst = -1;
        int jFirst = -1;
        for (int i = 0; i < words.length; i++) {
            // 先找word1 再找word2
            if (words[i].equals(word1)) {
                iFirst = i;
            }
            if (iFirst != -1 && words[i].equals(word2)) {
                result = Math.min(i - iFirst, result);
                iFirst = -1;
            }
            // 先找word2 再找word1
            if (words[i].equals(word2)) {
                jFirst = i;
            }
            if (jFirst != -1 && words[i].equals(word1)) {
                result = Math.min(i - jFirst, result);
                jFirst = -1;
            }
        }
        return result;
    }
}
