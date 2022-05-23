/*
 * Copyright (C) 2022 dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.studyplan;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author jiaxingwu
 * @date 2022/2/21 下午10:39
 * @description 简单算法计划
 * https://leetcode-cn.com/study-plan/algorithms/?progress=wvqoo0i
 */
public class EasyPlan {
    /**
     * https://leetcode-cn.com/problems/binary-search/
     */
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= nums.length - 1 && j >= 0) {
            int k = (i + j) / 2;
            if (nums[k] == target) {
                return nums[k];
            }
            if (nums[k] < target) {
                i = k + 1;
            }
            if (nums[k] > target) {
                j = k - 1;
            }
        }
        return -1;
    }

    /**
     * https://leetcode-cn.com/problems/first-bad-version/
     */
    public int firstBadVersion(int n) {
        int i = 0, j = n;
        while (i < j) {
            int m = i + ((j - i) >> 1);
            if (isBadVersion(m)) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    /**
     * https://leetcode-cn.com/problems/search-insert-position/
     */
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target) {
                j = m;
            }
            if (nums[m] < target) {
                i = m + 1;
            }
        }
        return target > nums[i] ? i + 1 : i;
    }

    private static boolean isBadVersion(int i) {
        return i >= 3;
    }

    /**
     * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
     */
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] data = new int[nums.length];
        int index = data.length - 1;
        while (i <= j) {
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];
            if (a == b) {
                if (i != j) {
                    data[index--] = a;
                    i++;
                }
                data[index--] = b;
                j--;
            }
            if (a < b) {
                data[index--] = b;
                j--;
            }
            if (a > b) {
                data[index--] = a;
                i++;
            }
        }
        return data;
    }

    /**
     * https://leetcode-cn.com/problems/rotate-array/
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        exchange(nums, 0, nums.length - 1);
        exchange(nums, 0, k - 1);
        exchange(nums, k, nums.length - 1);
    }

    private void exchange(int[] nums, int i, int j) {
        int m = i, n = j;
        while (m <= n) {
            int temp = nums[m];
            nums[m] = nums[n];
            nums[n] = temp;
            m++;
            n--;
        }
    }

    /**
     * https://leetcode-cn.com/problems/move-zeroes/
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
            i++;
        }
        for (int j = index; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    /**
     * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int search = search(numbers, i + 1, target - number);
            if (search != -1) {
                ints[0] = i + 1;
                ints[1] = search + 1;
                return ints;
            }
        }

        return ints;
    }

    private int search(int[] numbers, int startIndex, int target) {
        int i = startIndex, j = numbers.length;
        while (i <= j) {
            int k = (i + j) / 2;
            if (numbers[k] == target) {
                return k;
            }
            if (numbers[k] > target) {
                j = k - 1;
            }
            if (numbers[k] < target) {
                i = k + 1;
            }
        }
        return -1;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-string/
     */
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
     */
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            char[] s1 = split[i].toCharArray();
            reverseString(s1);
            if (i != split.length - 1) {
                str.append(new String(s1)).append(" ");
            } else {
                str.append(new String(s1));
            }
        }
        return str.toString();
    }

//    /**
//     * https://leetcode-cn.com/problems/middle-of-the-linked-list/
//     */
//    public ListNode middleNode(ListNode head) {
//        ListNode fast = head.next;
//        ListNode slow = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return fast == null ? slow : slow.next;
//    }
//
//    /**
//     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
//     */
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode listNode = new ListNode(-1);
//        listNode.next = head;
//        ListNode fast = listNode;
//        ListNode slow = listNode;
//        while (n-- != 0) {
//            fast = fast.next;
//        }
//        while (fast.next != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        slow.next = slow.next.next;
//        return listNode.next;
//    }

    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int startIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                startIndex = Math.max(startIndex, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - startIndex + 1);
        }
        return result;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }
        }
        HashMap<Character, Integer> newMap = new HashMap<>();
        int i = 0, j = s1.length() - 1;
        for (int k = 0; k <= j; k++) {
            if (newMap.containsKey(s2.charAt(k))) {
                newMap.put(s2.charAt(k), newMap.get(s2.charAt(k)) + 1);
            } else {
                newMap.put(s2.charAt(k), 1);
            }
        }
        while (j < s2.length()) {
            if (isInclusion(map, newMap, s2, i, j)) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }


    private boolean isInclusion(HashMap<Character, Integer> map, HashMap<Character, Integer> newMap,
                                String s2, Integer i, Integer j) {
        if (i != 0) {
            Integer iIndex = newMap.getOrDefault(s2.charAt(i - 1), 0);
            if (iIndex != 0) {
                newMap.put(s2.charAt(i - 1), iIndex - 1);
            }
            Integer jIndex = newMap.getOrDefault(s2.charAt(j), 0);
            newMap.put(s2.charAt(j), jIndex + 1);
        }
        for (Map.Entry<Character, Integer> entry : newMap.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            if (!Objects.equals(map.get(entry.getKey()), newMap.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        EasyPlan easyPlan = new EasyPlan();
//        int search = eas
//        yPlan.search(ints1, 0, 0);
        String str = null;
        switch (str) {
            case "":
                break;
        }

//        boolean b = easyPlan.checkInclusion("abc", "cccccbabbbaaaa");
//        System.out.println(b);
    }
}
