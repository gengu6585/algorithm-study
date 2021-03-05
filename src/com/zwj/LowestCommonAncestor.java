package com.zwj;

import java.util.ArrayDeque;

/**
 * @Author:zengwenjie
 * @Date:2021/3/5 12:02
 */
public class LowestCommonAncestor {

    ArrayDeque<TreeNode> pstack=null;
    ArrayDeque<TreeNode> qstack=null;
    public static void main(String[] args) {
        int []nums = {3, 5, 1, 6, 2, 0, 8, 0, 0, 7, 4};
        TreeNode root = new TreeNode(nums);
        TreeNode.show(root);
        TreeNode p = new TreeNode(6);
        TreeNode q = new TreeNode(4);
        TreeNode father = new LowestCommonAncestor().solution(root, p, q);
        System.out.println("公共父元素为----"+father.toString());
    }
    TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == null || q == null) {
            return null;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        preOrder(root, p, q, stack);
        TreeNode father = root;
        while (pstack.size() != 0 && qstack.size() != 0) {
            if (pstack.peekLast().value != qstack.peekLast().value) {
                return father;
            }
            father = pstack.removeLast();
            qstack.removeLast();
        }
        return father;
    }

    void preOrder(TreeNode node,TreeNode p,TreeNode q, ArrayDeque<TreeNode> stack) {
        if (node == null) {
            return;
        }
        stack.push(node);
        stack.clone();
        if (node.value == p.value) {
//            pStack.addAll(stack);
            this.pstack = stack.clone();
        }
        if (node.value == q.value) {
//            qStack.addAll(stack);
            this.qstack = stack.clone();
        }
        preOrder(node.left,p,q, stack);
        preOrder(node.right,p,q, stack);
        stack.pop();
    }
}
