package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/3 21:46
 * @description https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(10);

        listNode1.next = listNode2;
        listNode2.next = listNode3;


        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(20);
        ListNode listNode7 = new ListNode(30);

        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;


        MergeTwoLists mergeTwoLists = new MergeTwoLists();

        ListNode listNode = mergeTwoLists.mergeTwoLists(listNode1, listNode4);


        System.out.println(listNode);


    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(-1);
        ListNode head = node;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;

            if (val1 == val2) {
                node.next = new ListNode(val1);
                node.next.next = new ListNode(val1);
                l1 = l1.next;
                l2 = l2.next;
                node = node.next.next;
                continue;
            }

            if (val1 < val2) {
                node.next = new ListNode(val1);
                l1 = l1.next;
            }
            if (val1 > val2) {
                node.next = new ListNode(val2);
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }
        return head.next;
    }
}
