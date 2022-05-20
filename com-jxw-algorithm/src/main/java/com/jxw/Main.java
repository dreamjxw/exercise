package com.jxw;

import com.jxw.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        List<List<Integer>> lists = new Main().levelOrder(treeNode1);
        System.out.println(lists.toString());

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> resultList = new LinkedList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> list;
        queue.offer(root);
        boolean temp = false;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            list = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            resultList.addFirst(list);
        }
        return resultList;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return null;
        }
        int maxNumIndex = leftIndex;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (nums[i] > nums[maxNumIndex]) {
                maxNumIndex = i;
            }
        }
        TreeNode treeNode = new TreeNode(nums[maxNumIndex]);
        treeNode.left = constructMaximumBinaryTree(nums, leftIndex, maxNumIndex);
        treeNode.right = constructMaximumBinaryTree(nums, maxNumIndex + 1, rightIndex);
        return treeNode;
    }
}