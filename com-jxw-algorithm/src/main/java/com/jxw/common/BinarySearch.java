package com.jxw.common;

/**
 * @author jiaxingwu
 * @date 2020/5/18 13:40
 * <p>二分查找</p>
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] data = new int[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
        Integer integer = binarySearch(data, 10, 0, data.length);
        System.out.println(integer);
    }

    private static Integer binarySearch(int[] data, int key, int left, int right) {
        int index = (left + right) / 2;
        if (left >= right) {
            return null;
        }
        if (data[index] == key) {
            return index;
        }
        if (data[index] < key) {
            left++;
        }
        if (data[index] > key) {
            right--;
        }
        return binarySearch(data, key, left, right);
    }

}
