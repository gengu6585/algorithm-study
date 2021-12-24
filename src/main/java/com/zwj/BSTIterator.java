package com.zwj;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayDeque;

/**
 * @Author:zengwenjie
 * @Date:2021/3/29 8:54
 */
public class BSTIterator {
    private TreeNode root;
    private ArrayDeque<TreeNode> stack;
    private TreeNode p;
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      } }

    public BSTIterator(TreeNode node) {
        if (node == null) {
            return;
        }
        this.root = node;
        this.stack = new ArrayDeque<TreeNode>();
        p = node;
    }

    public int next() {
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        TreeNode pop = stack.pop();
        int result = pop.val;
        p = pop.right;
        return result;
    }

    public void testCoda() {
    }

    public boolean hasNext() {
        return !stack.isEmpty()||p!=null;
    }
}
