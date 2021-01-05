package com.jxw.common;

import com.jxw.domain.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jiaxingwu
 * @date 2020/5/18 15:54
 * @Description 二叉树层序遍历
 */
public class LevelTreeOrder {
    public static void main(String[] args) {

    }

    private static void levelTree(Tree root) {
        if (root == null) {
            return;
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree tree = queue.poll();
            System.out.println(tree);
            if (tree.getlChild() != null) {
                queue.add(tree.getlChild());
            }
            if (tree.getrChild() != null) {
                queue.add(tree.getrChild());
            }
        }
    }
}
