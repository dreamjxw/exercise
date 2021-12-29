package com.jxw.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiaxingwu
 * @date 2021/1/7 18:12
 * @description https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 */
public class RobotMovingCount {


    public static void main(String[] args) {
        RobotMovingCount movingCount = new RobotMovingCount();
        int count = movingCount.movingCount(1, 2, 1);
        System.out.println(count);
    }

    public int movingCount(int m, int n, int k) {
        return movingCount(new HashSet<>(), m, n, 0, 0, 0, k);
    }

    private int movingCount(Set<String> set, int m, int n, int x, int y, int count, int k) {
        if (x > m-1 || y > n-1 || x < 0 || y < 0 || set.contains(x + "-" + y)) {
            return count;
        }

        if (indexSum(x, y) > k) {
            return count;
        }

        set.add(x + "-" + y);

        count += 1;

        count = movingCount(set, m, n, x - 1, y, count, k);
        count = movingCount(set, m, n, x + 1, y, count, k);
        count = movingCount(set, m, n, x, y + 1, count, k);
        count = movingCount(set, m, n, x, y - 1, count, k);
        return count;
    }

    private int indexSum(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            count += (x % 10 + y % 10);
            x = x / 10;
            y = y / 10;
        }
        return count;
    }
}
