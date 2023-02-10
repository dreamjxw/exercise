/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

/**
 * @author jiaxingwu
 * @date 2022/7/13 下午11:57
 * @description do something with this class...
 */
public class 行星碰撞 {
    public static void main(String[] args) {
        int[] ints = {5, 10, -5, 1, 2, -4, -6, -3, 2, 5, 1, 5, 9};
        int[] ints1 = asteroidCollision(ints);
        System.out.println(ints1);
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int temp = 0;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] >= 0) {
                continue;
            }
            int j = i - 1;
            while (j >= 0) {
                if (asteroids[j] <= 0) {
                    j--;
                    continue;
                }
                int iAbs = Math.abs(asteroids[i]);
                int jAbs = Math.abs(asteroids[j]);
                if (iAbs == jAbs) {
                    asteroids[i] = 0;
                    asteroids[j] = 0;
                    temp += 2;
                    break;
                }
                if (iAbs < jAbs) {
                    asteroids[i] = 0;
                    temp++;
                    break;
                }

                if (iAbs > jAbs) {
                    asteroids[j] = 0;
                    temp++;
                    j--;
                }
            }
        }
        if (temp == 0) {
            return asteroids;
        }
        int[] result = new int[asteroids.length - temp];
        int j = 0;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] == 0) {
                continue;
            }
            result[j++] = asteroids[i];
        }
        return result;
    }
}
