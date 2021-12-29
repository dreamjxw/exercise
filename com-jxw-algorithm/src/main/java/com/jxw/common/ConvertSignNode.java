package com.jxw.common;

import com.jxw.domain.SignNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 反转单向链表
 */
public class ConvertSignNode {
    public static void main(String[] args) {
        SignNode signNode1 = new SignNode(1);
        SignNode signNode2 = new SignNode(2);
        SignNode signNode3 = new SignNode(3);
        SignNode signNode4 = new SignNode(4);
        SignNode signNode5 = new SignNode(5);
        signNode5.setNext(signNode1);
        signNode4.setNext(signNode5);
        signNode3.setNext(signNode4);
        signNode2.setNext(signNode3);
        signNode1.setNext(signNode2);
        SignNode node = convert(signNode1);
        System.out.println(node);
    }


    private static SignNode convert(SignNode node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        SignNode temp = new SignNode(-1);
        temp.setNext(node);
        SignNode first = temp.getNext();
        SignNode second = first.getNext();
        Set<SignNode> signNodes = new HashSet<>();
        while (second != null) {
            if (signNodes.contains(first)) {
                return node;
            }
            signNodes.add(second);

            first.setNext(second.getNext());
            second.setNext(temp.getNext());
            temp.setNext(second);
            second = first.getNext();
        }
        return temp.getNext();
    }
}