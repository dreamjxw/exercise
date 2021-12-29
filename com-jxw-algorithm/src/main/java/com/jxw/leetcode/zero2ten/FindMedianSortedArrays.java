package com.jxw.leetcode.zero2ten;

/**
 * @author jiaxingwu
 * @date 2019/8/6 17:09
 * @Description 第四题 寻找两个有序数组的中位数
 */
public class FindMedianSortedArrays {
    /**
     * 两个有序数组的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = 0, b = 0, i = 0;
        int[] result = new int[nums1.length + nums2.length];
        while (a <= nums1.length || b < nums2.length) {
            if (a == nums1.length) {
                putArray(result, nums2, i, b);
                break;
            }
            if (b == nums2.length) {
                putArray(result, nums1, i, a);
                break;
            }
            int left = nums1[a];
            int right = nums2[b];
            if (left <= right) {
                result[i] = left;
                if (a < nums1.length) {
                    a++;
                }
            } else {
                result[i] = right;
                if (b < nums2.length) {
                    b++;
                }
            }
            i++;
        }
        return result.length % 2 == 0 ? ((result[result.length / 2 - 1] + result[result.length / 2]) / 2.0) : (result[result.length / 2]);
    }

    private void putArray(int[] result, int[] arm, int resultIndex, int armIndex) {
        while (armIndex < arm.length) {
            result[resultIndex++] = arm[armIndex++];
        }
    }
}
