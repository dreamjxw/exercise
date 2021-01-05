package com.jxw.common;

import com.jxw.domain.SignNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiaxingwu
 * @date 2020/5/20 17:08
 * @Description 判断链表是否有环
 */
public class CheckNodeIsRing {
    public static void main(String[] args) {
        SignNode signNode1 = new SignNode(1);
        SignNode signNode2 = new SignNode(2);
        SignNode signNode3 = new SignNode(3);
        SignNode signNode4 = new SignNode(4);
        SignNode signNode5 = new SignNode(5);
//        signNode5.setNext(signNode1);
        signNode4.setNext(signNode5);
        signNode3.setNext(signNode4);
        signNode2.setNext(signNode3);
        signNode1.setNext(signNode2);
        SignNode signNode = checkIsRing4Hash(signNode1);
        System.out.println(signNode);
    }

    private static SignNode checkIsRing(SignNode node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        SignNode slow = node;
        SignNode fast = node;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    private static SignNode checkIsRing4Hash(SignNode node) {
        if (node == null || node.getNext() == null) {
            return node;
        }

        Set<SignNode> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.getNext();
        }
        return null;
    }
}
