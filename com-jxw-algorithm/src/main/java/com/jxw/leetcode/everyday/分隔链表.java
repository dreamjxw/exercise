package com.jxw.leetcode.everyday;

/**
 * @author jiaxingwu
 * @date 2021/1/4 16:07
 * @description https://leetcode-cn.com/problems/partition-list/
 * <p>
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 */
public class 分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode bigNode = new ListNode(0);
        ListNode bigNodeHead = bigNode;

        ListNode sNode = new ListNode(0);
        ListNode sNodeHead = sNode;

        while (head != null) {
            int val = head.val;
            if (val < x) {
                sNode.next = new ListNode(val);
                sNode = sNode.next;
            } else {
                bigNode.next = new ListNode(val);
                bigNode = bigNode.next;
            }
            head = head.next;
        }
        sNode.next = bigNodeHead.next;
        return sNodeHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}