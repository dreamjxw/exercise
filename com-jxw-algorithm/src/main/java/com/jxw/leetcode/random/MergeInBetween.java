/*
 * Copyright (C) 2022 Dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.random;

import com.jxw.domain.ListNode;

/**
 * @author jiaxingwu
 * @date 2022/5/10 下午5:52
 * @description 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * <p>
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-in-between-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode result = new ListNode(-1);
        result.next = list1;
        ListNode list3 = null;
        int count = 1;
        while (list1.next != null) {
            if (count == a) {
                list3 = list1.next;
                list1.next = list2;
            }
            count++;
            list1 = list1.next;
        }

        while (list3 != null) {
            if (a == b) {
                list1.next = list3.next;
                break;
            }
            a++;
            list3 = list3.next;
        }
        return result.next;
    }
}
