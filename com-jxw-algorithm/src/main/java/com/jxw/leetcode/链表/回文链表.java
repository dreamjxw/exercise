/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.链表;

import com.jxw.domain.ListNode;

/**
 * @author jiaxingwu
 * @date 2022/5/28 上午12:00
 * @description 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * https://leetcode.cn/problems/palindrome-linked-list/
 */
public class 回文链表 {
    /**
     * 1. 先找到链表中点(中间元素)
     * 2. 翻转后半截链表
     * 3. 后半截链表与前一截判断是否回文
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 快慢指针找到中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 翻转后半截链表
        ListNode temp = new ListNode(-1);
        temp.next = slow;
        ListNode first = slow;
        ListNode second = slow.next;
        while (second != null) {
            first.next = second.next;
            second.next = temp.next;
            temp.next = second;
            second = first.next;
        }
        // 比较
        slow = temp.next;
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}
