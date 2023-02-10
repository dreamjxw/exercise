/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2022/7/1 下午10:56
 * @description 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * <p>
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/different-ways-to-add-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 */
public class 为运算表达式设计优先级 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length() - 1; i++) {
            char charAt = expression.charAt(i);
            if (charAt == '+' || charAt == '-' || charAt == '*') {
                // 按照运算符拆分 左边
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                // 按照运算符拆分 右边
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                // 将左右两边所有情况组合
                for (Integer l : left) {
                    for (Integer r : right) {
                        if (charAt == '+') {
                            result.add(l + r);
                        }
                        if (charAt == '-') {
                            result.add(l - r);
                        }
                        if (charAt == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        // list为空  说明当前不包含运算符，直接把这个数放进去。 也是递归终止条件
        if (result.isEmpty()) {
            result.add(Integer.valueOf(expression));
        }
        return result;
    }

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            count += (z & 1);
            z = z >> 1;
        }
        return count;
    }
}
