/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.链表;

import com.jxw.domain.ListNode;

/**
 * @author jiaxingwu
 * @date 2022/5/26 下午10:40
 * @description 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode first = head;
        ListNode second = head.next;
        while (second != null) {
            first.next = second.next;
            second.next = node.next;
            node.next = second;

            second = first.next;
        }
        return node.next;
    }
}
