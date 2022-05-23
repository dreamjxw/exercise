/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

/**
 * @author jiaxingwu
 * @date 2022/5/12 下午10:54
 * @description 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 * <p>
 * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 * <p>
 * abc
 * bce
 * cae
 * 你需要找出并删除 不是按字典序升序排列的 列。在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按升序排列的，而列 1（'b', 'c',
 * 'a'）不是，所以要删除列 1 。
 * <p>
 * 返回你需要删除的列数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/delete-columns-to-make-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDeletionSize {
    public int minDeletionSize(String[] strs) {
        int cow = strs[0].length();
        int result = 0;

        for (int i = 0; i < cow; i++) {
            result += check(strs, i);
        }
        return result;
    }

    private int check(String[] strs, int cow) {
        int i = 0;
        while (i + 1 < strs.length) {
            if (strs[i].charAt(cow) > strs[i + 1].charAt(cow)) {
                return 1;
            }
            i++;
        }
        return 0;
    }
}
