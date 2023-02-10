/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

import java.util.Comparator;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2022/7/7 下午10:51
 * @description 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)
 * ，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/replace-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 单词替换 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] splits = sentence.split(" ");
        dictionary.sort(Comparator.comparing(String::length));
        StringBuilder result = new StringBuilder();
        for (String split : splits) {
            for (int i = 0; i < dictionary.size(); i++) {
                if (split.startsWith(dictionary.get(i))) {
                    result.append(dictionary.get(i)).append(" ");
                    break;
                }
                if (i == dictionary.size() - 1) {
                    result.append(split).append(" ");
                }
            }
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }
}
