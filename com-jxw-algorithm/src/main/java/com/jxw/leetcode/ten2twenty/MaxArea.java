package com.jxw.leetcode.ten2twenty;

/**
 * @author jiaxingwu
 * @date 2019/8/8 17:46
 * @Description 第十一题  盛最多水的容器
 */
public class MaxArea {
    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] ints = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea.maxArea(ints));
    }

    public int maxArea(int[] height) {
        int result = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        while (leftIndex < rightIndex) {
            int i = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
            result = Math.max(result, i);
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
                continue;
            }
            rightIndex--;
        }
        return result;
    }
}
