package com.jxw.leetcode.ten2twenty;

/**
 * @author jiaxingwu
 * @date 2019/9/5 15:34
 * @Description 第十九题. 删除链表的倒数第N个节点
 *   1.  在链表前添加一个节点，用来处理链表长度较短是出现的next为空问题
 *   2.  采用双指针的方法，一个节点先到第n+1个节点，然后和第二个节点（从链表头结点开始）一起走，只到第一个节点到达链表尾部。
 *      此时第二个节点所在位置即为倒数第n+1个节点，使其下一个节点指向下下个节点即可。
 *
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        d.next = e;
        c.next = d;
        b.next = c;
        a.next = b;
        ListNode listNode = new RemoveNthFromEnd().removeNthFromEnd(a, 2);
        System.out.println(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode left = listNode;
        ListNode right = listNode;
        for (int i = 0; i <= n; i++) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return listNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}