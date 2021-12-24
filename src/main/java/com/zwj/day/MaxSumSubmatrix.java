package com.zwj.day;

import java.util.TreeSet;

/**
 * @Author:zengwenjie
 * @Date:2021/4/23 12:16
 */
public class MaxSumSubmatrix {
    public static void main(String[] args) {
        int[][] matrix = null;
        int k = 0;
        int result = new MaxSumSubmatrix().solution(matrix, k);
        System.out.println(result);
    }
    int solution(int[][] matrix, int k) {
        if (matrix == null) {
            return 0;
        }
        if (matrix.length == 0) {

            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(0);
                int s = 0;
                for (int l = 0; l < n; l++) {
                    sum[l] += matrix[j][l];
                    s += sum[l];
                    Integer ceiling = treeSet.ceiling(s - k);
                    if (ceiling != null) {
                        ans = Math.max(ans, s-ceiling);
                    }
                    treeSet.add(s);
                }



            }

        }

        return ans;
    }
}
