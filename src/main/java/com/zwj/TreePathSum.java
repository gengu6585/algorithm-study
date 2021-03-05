package com.zwj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zengwenjie
 * @Date:2021/3/4 20:31
 */
public class TreePathSum {
    public static void main(String[] args) {
        int[] ints1 = {5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0, 0, 5, 1};
        TreeNode treeNode = new TreeNode(ints1);
        TreeNode.show(treeNode);
        int target = 22;
        boolean is = new TreePathSum().solution(treeNode, target);
        System.out.println();
    }
    boolean solution(TreeNode treeNode, int target) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<ArrayDeque> result = new ArrayList<ArrayDeque>();
        preOrder(treeNode, stack, target, result);
        if (result.size() != 0) {
            System.out.println(result.toString());
            return true;
        } else return false;
    }

    void preOrder(TreeNode treeNode, ArrayDeque<Integer> stack, int target, List<ArrayDeque> result) {
        if (treeNode == null) {
            return;
        }
        target -= treeNode.value;
        stack.push(treeNode.value);
        if (target < 0) {
            stack.pop();
            return;
        }
        if (target == 0&&treeNode.left==null&&treeNode.right==null) {
            result.add(stack.clone());
            stack.pop();
            return;
        }

        preOrder(treeNode.left,stack,target,result);
        preOrder(treeNode.right, stack,target, result);
        stack.pop();
    }
}
