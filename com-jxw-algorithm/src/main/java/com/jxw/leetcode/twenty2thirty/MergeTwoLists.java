package com.jxw.leetcode.twenty2thirty;

/**
 * @author jiaxingwu
 * @date 2019/9/6 17:13
 * @Description
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        b.next = c;
        a.next = b;
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(5);
        d.next = e;

        ListNode x = new MergeTwoLists().mergeTwoLists(a, null);
        System.out.println(x);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        return doBusiness(l1, l2, new ListNode(0));
    }

    private ListNode doBusiness(ListNode l1, ListNode l2, ListNode result) {
        if (l1 == null) {
            return addLastItem(l2, result);
        }
        if (l2 == null) {
            return addLastItem(l1, result);
        }
        result.next = new ListNode(Math.min(l1.val, l2.val));
        if (l1.val > l2.val) {
            doBusiness(l1, l2.next, result.next);
        } else {
            doBusiness(l1.next, l2, result.next);
        }
        return result.next;
    }

    private ListNode addLastItem(ListNode item, ListNode result) {
        if (item == null) {
            return result.next;
        }
        result.next = new ListNode(item.val);
        addLastItem(item.next, result.next);
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
