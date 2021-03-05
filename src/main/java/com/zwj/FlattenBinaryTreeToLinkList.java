package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/5 14:38
 */
public class FlattenBinaryTreeToLinkList {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 5, 3, 4, 0, 6};
//        TreeNode root = new TreeNode(nums);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        TreeNode.show(root);
        TreeNode solution = new FlattenBinaryTreeToLinkList().solution(root);
        TreeNode temp=root;
        TreeNode.show(root);
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.right;
        }

    }
    TreeNode solution(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left == null && root.right != null) {
            return solution(root.right);
        }
        if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
            return solution(root.right);
        }
        if (root.left != null && root.right != null) {
            TreeNode right = root.right;
            TreeNode leftLast = solution(root.left);
            root.right = root.left;
            leftLast.right = right;
            root.left = null;
            return solution(root.right);
        }




        return null;
    }
}
