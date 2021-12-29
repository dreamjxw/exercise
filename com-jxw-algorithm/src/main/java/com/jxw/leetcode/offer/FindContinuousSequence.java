package com.jxw.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiaxingwu
 * @date 2021/2/4 16:48
 * @description https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        FindContinuousSequence sequence = new FindContinuousSequence();
        int[][] ints = sequence.findContinuousSequence(100);
        System.out.println(Arrays.deepToString(ints));
    }

    public int[][] findContinuousSequence(int target) {
        int flag = target % 2 == 0 ? target / 2 : (target / 2) + 1;
        List<int[]> result = new ArrayList<>();
        for (int i = 1, j = 2; i < flag && j <= flag; ) {
            int k = j - i + 1;
            int data = i * k + (k * (k - 1) / 2);
            if (data == target) {
                result.add(sum(i, k));
                i++;
            }
            if (data < target) {
                j++;
            }
            if (data > target) {
                i++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    private int[] sum(int start, int count) {
        int[] ints = new int[count];
        for (int i = 0; i < count; i++) {
            ints[i] = start++;
        }
        return ints;
    }
}
