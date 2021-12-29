package com.jxw.leetcode.zero2ten;

/**
 * @author jiaxingwu
 * @date 2019/8/6 10:53
 * @Description 第二题  链表加法
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        b.next = c;
        a.next = b;
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(5);
        d.next = e;

        System.out.println(new AddTwoNumbers().addTwoNumbers(a, d));
    }

    /**
     * 链表加法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, new ListNode(0));
    }

    private ListNode add(ListNode l1, ListNode l2, ListNode result) {
        l1 = (l1 == null) ? new ListNode(0) : l1;
        l2 = (l2 == null) ? new ListNode(0) : l2;
        int now = (l1.val + l2.val + result.val) % 10;
        int next = (l1.val + l2.val + result.val) / 10;
        result.val = now;
        if (l1.next == null && l2.next == null && next == 0) {
            return result;
        }
        result.next = new ListNode(next);
        add(l1.next, l2.next, result.next);
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
