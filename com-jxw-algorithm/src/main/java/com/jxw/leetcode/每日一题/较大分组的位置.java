package com.jxw.leetcode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2021/1/5 10:59
 * @description https://leetcode-cn.com/problems/positions-of-large-groups/
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * <p>
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 * <p>
 * <p>eg:
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 */
public class 较大分组的位置 {
    public static void main(String[] args) {
        较大分组的位置 domain = new 较大分组的位置();
        List<List<Integer>> list = domain.largeGroupPositions("abbxxxxzzyyyyy");
        System.out.println(list);
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        if (s == null || s.length() < 3) {
            return new ArrayList<>();
        }
        s = s + "#";
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0, j = 1; i < s.length() && j < s.length(); j++) {
            if (s.charAt(i) != s.charAt(j)) {
                if (j - i > 2) {
                    ArrayList<Integer> data = new ArrayList<>();
                    data.add(i);
                    data.add(j - 1);
                    lists.add(data);
                }
                i = j;
            }
        }
        return lists;
    }
}
