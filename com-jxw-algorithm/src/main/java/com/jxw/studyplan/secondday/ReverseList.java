package com.jxw.studyplan.secondday;

import com.jxw.domain.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode node = new ListNode(-1);
        ListNode first = node.next;
        ListNode second = first.next;
        while (second != null) {
            first.next = second.next;
            second.next = node.next;
            node.next = second;
            second = first.next;
        }
        return node.next;
    }
}