package com.jxw.leetcode.offer;

import java.util.Stack;

/**
 * @author jiaxingwu
 * @date 2021/1/5 14:55
 * @description https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class ReversePrint {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode1.next = listNode3;
        listNode3.next = listNode2;
        int[] ints = reversePrint(listNode1);
        System.out.println(ints);
    }

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] data = new int[stack.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = stack.pop();

        }
        return data;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
