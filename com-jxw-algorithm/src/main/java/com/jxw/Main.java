package com.jxw;

import com.jxw.domain.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);

        treeNode1.left = treeNode3;
        treeNode3.right = treeNode2;
        new Main().recoverTree(treeNode1);
        System.out.println(treeNode1);
    }

    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        loop(root, list);

        int first = 0;
        int second = 0;
        List<Integer> list2 = new ArrayList<Integer>(list);
        list2.sort(Comparator.naturalOrder());
        boolean temp = true;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(list2.get(i))) {
                if (temp) {
                    first = list.get(i);
                    temp = false;
                } else {
                    second = list.get(i);
                }
            }
        }

        repact(root, first, second);
    }


    private void loop(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        loop(root.left, list);
        list.add(root.val);
        loop(root.right, list);
    }

    private void repact(TreeNode root, int first, int second) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (val == first) {
            root.val = second;
        }
        if (val == second) {
            root.val = first;
        }
        repact(root.left, first, second);
        repact(root.right, first, second);
    }
}