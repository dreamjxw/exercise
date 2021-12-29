package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/8 15:20
 * @description https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headA1 = headA;
        ListNode headB1 = headB;
        while (headA1 != headB1) {

            if (headA1 == null) {
                headA1 = headB;
            } else {
                headA1 = headA1.next;
            }

            if (headB1 == null) {
                headB1 = headA;
            } else {
                headB1 = headB1.next;
            }


        }
        return headA1;
    }
}
