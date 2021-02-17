package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/17 23:20
 * @description https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        ListNode fastNode = listNode.next;

        while (fastNode.next != null) {
            if (fastNode.next.val == val) {
                fastNode.next = fastNode.next.next;
                break;
            }
            fastNode = fastNode.next;
        }
        return listNode.next;
    }
}
