/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.链表;

import com.jxw.domain.ListNode;

/**
 * @author jiaxingwu
 * @date 2022/6/5 下午2:19
 * @description 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 链表加法 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int upVal = 0;
        ListNode result = l1;
        while (true) {
            int temp = l1.val + l2.val + upVal;
            upVal = temp / 10;
            l1.val = temp % 10;

            if (l1.next == null && l2.next == null && upVal == 0) {
                break;
            }
            if (l1.next == null) {
                l1.next = new ListNode(0);
            }
            if (l2.next == null) {
                l2.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return result;
    }
}
