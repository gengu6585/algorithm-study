package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/4/21 19:58
 */
public  class BiTreeDye {
     public static class TreeNode {
      int val;
     TreeNode left;
    TreeNode right;
     TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        int k = 3;
        int result = new BiTreeDye().solution(treeNode, k);
        System.out.println(result);
    }
    int solution(TreeNode node, int k) {
        int[] dp = dfs(node, k);
        int result = dp[0];
        for (int i = 1; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;

    }

        int[] dfs(TreeNode node, int k) {
            int[] dp = new int[k + 1];
            if (node == null) {
                return new int[k + 1];
            }
            int[] l = dfs(node.left, k);
            int[] r = dfs(node.right, k);
            int lMax = 0;
            int rMax = 0;
            for (int i = 0; i < k + 1; i++) {
                lMax = Math.max(lMax, l[i]);
                rMax = Math.max(rMax, r[i]);
            }
            dp[0] = lMax + rMax;
            for (int i = 1; i <= k; i++) {
                for (int j = 0; j <= i - 1; j++) {
                    dp[i] = Math.max(dp[i], l[j] + r[i - 1 - j] + node.val);
                }
            }
            return dp;
        }
}
