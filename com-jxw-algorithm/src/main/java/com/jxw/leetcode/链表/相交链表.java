/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.链表;

import com.jxw.domain.ListNode;

/**
 * @author jiaxingwu
 * @date 2022/5/27 上午12:03
 * @description 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode copyHeadA = headA;
        ListNode copyHeadB = headB;
        // 一定不能判断val的值   要直接判断对象
        while (copyHeadA != copyHeadB) {
            // 接上另外一截之后  直接重新判断  不用再next了
            if (copyHeadA == null) {
                copyHeadA = headB;
                continue;
            }
            if (copyHeadB == null) {
                copyHeadB = headA;
                continue;
            }
            copyHeadA = copyHeadA.next;
            copyHeadB = copyHeadB.next;
        }
        return copyHeadA;
    }
}
