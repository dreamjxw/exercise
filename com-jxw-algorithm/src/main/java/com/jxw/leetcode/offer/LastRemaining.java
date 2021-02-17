package com.jxw.leetcode.offer;

import java.util.ArrayList;

/**
 * @author jiaxingwu
 * @date 2021/2/7 20:37
 * @description https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 */
public class LastRemaining {
    public static void main(String[] args) {
        int i = new LastRemaining().lastRemaining1(5, 3);
        System.out.println(i);
    }


    public int lastRemaining(int n, int m) {
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dataList.add(i);
        }
        int temp = 0;
        while (dataList.size() != 1) {
            temp = (temp + m - 1) % dataList.size();
            dataList.remove(temp);
        }
        return dataList.get(0);
    }

    /**
     * (当前index + m) % 上一轮剩余数字的个数
     */
    public int lastRemaining1(int n, int m) {
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = (temp + m) % i;
        }
        return temp;
    }
}
