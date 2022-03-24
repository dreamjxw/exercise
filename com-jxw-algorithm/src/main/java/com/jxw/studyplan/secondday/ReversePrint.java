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
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        if (head.next == null) {
            return new int[head.val];
        }
        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        ListNode first = headNode.next;
        ListNode second = first.next;
        int arraySize = 1;
        while (second != null) {
            first.next = second.next;
            second.next = headNode.next;
            headNode.next = second;
            second = first.next;
            arraySize++;
        }
        int[] ints = new int[arraySize];
        head = headNode.next;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = head.val;
            head = head.next;
        }
        return ints;
    }
}