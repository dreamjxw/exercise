/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.链表;

import com.jxw.domain.ListNode;

/**
 * @author jiaxingwu
 * @date 2022/5/26 下午11:30
 * @description 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 反转链表II {
    /**
     * 先找到然后头插法翻转
     *
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode first = head;
        ListNode second = first.next;
        ListNode flag = result;
        int count = 1;
        while (first != null) {
            if (count != left) {
                first = first.next;
                second = second.next;
                flag = flag.next;
                count++;
                continue;
            }
            while (first != null) {
                if (count == right) {
                    return result.next;
                }
                count++;
                first.next = second.next;
                second.next = flag.next;
                flag.next = second;
                second = first.next;
            }
            return result.next;
        }
        return result.next;
    }
}
