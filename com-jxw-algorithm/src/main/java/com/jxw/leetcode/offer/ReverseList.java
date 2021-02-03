package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/3 21:38
 * @description https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode first = node.next;
        ListNode second = node.next.next;
        while (second != null) {
            first.next = second.next;
            second.next = node.next;
            node.next = second;

            second = first.next;
        }
        return node.next;
    }
}
