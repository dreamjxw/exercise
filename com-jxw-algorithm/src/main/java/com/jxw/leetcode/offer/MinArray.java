package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/1/6 21:40
 * @description https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 */
public class MinArray {
    public static void main(String[] args) {
        MinArray minArray = new MinArray();
        int[] data = {2, 2, 2, 0, 1};
        int i = minArray.minArray(data);
        System.out.println(i);
    }

    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }

        if (numbers.length == 1) {
            return numbers[0];
        }

        for (int i = 0, j = 1; j < numbers.length; i++, j++) {
            if (numbers[j] < numbers[i]) {
                return numbers[j];
            }
        }

        return numbers[0];
    }
}
