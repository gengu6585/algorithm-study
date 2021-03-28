package com.zwj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * description: 非递归后序遍历
 * @param: LeetCodeLink:https://leetcode-cn.com/problems/binary-tree-postorder-traversal/comments/
 * @return:
 * @author zwj
 * @date: 2021/3/28 10:54
 */

public class PosterOrderTraversal {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1,5,5,6,3};
        TreeNode treeNode = new TreeNode(nums);
        TreeNode.show(treeNode);
        System.out.println("前序遍历"+new PosterOrderTraversal().preorder(treeNode));;
        System.out.println("后序遍历"+new PosterOrderTraversal().soluton1(treeNode));;
    }
    List<Integer> soluton1(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        LinkedList<Integer> rs = new LinkedList<>();
        if (root == null) {
            return rs;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            rs.addFirst(temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        return rs;
    }

    List<Integer> soluton(TreeNode node) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode p = node;
        TreeNode lastVisited = null;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {

                stack.push(p);
                p = p.left;

            } else {
                p = stack.peek();
                if (p.right == null || p.right == lastVisited) {
                    result.add(p.val);
                    lastVisited = p;
                    stack.pop();
                    p = null;
                } else {

                    p = p.right;
                }
            }

        }

        return result;
    }List<Integer> soluton2(TreeNode node) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode p = node;
        TreeNode lastVisited = null;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                result.add(p.val);
                stack.push(p);
                p = p.left;

            }
            p = stack.peek();

            stack.pop();
            p = p.right;
        }

        return result;
    }

    List<Integer> preorder(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.addLast(temp.val); //遍历
            if (temp.left != null) {
                stack.push(temp.right);
            }
            if (temp.right != null) {
                stack.push(temp.left);
            }
        }
        return result;
    }
}
