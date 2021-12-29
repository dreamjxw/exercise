package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/4 18:13
 * @description https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * <p>
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //叶子节点还在找到   返回null
        if (root == null) {
            return null;
        }
        // 找到节点了 返回root
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        // 找左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 找右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右子树都没找到  返回null
        if (left == null && right == null) {
            return null;
        }
        // 左子树中找到了   返回左子树
        if (left != null && right == null) {
            return left;
        }
        // 右子树中找到了   返回右子树
        if (left == null && right != null) {
            return right;
        }
        // 左右子树中都找到了  返回根节点
        return root;
    }
}
