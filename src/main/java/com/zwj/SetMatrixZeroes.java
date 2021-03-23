package com.zwj;

/*** 
 * description: 矩阵置零，要求使用O(1)辅助空间
 * @param: LeetCodeLink：https://leetcode-cn.com/problems/set-matrix-zeroes/
 * @return:
 * @author zwj
 * @date: 2021/3/21 18:31
 */
public class SetMatrixZeroes {
    /**
     有跟我一样使用递归的吗？对矩阵内的每一个数进行深搜：

     1.为0时，修改为一个特殊的数做个标记，并找到所在行所在列为0的数进行深搜

     2.不为0时，返回

     最后在扫描矩阵的所有数，把被标记的数改为0
     ```cs
     class Solution {
     public void setZeroes(int[][] matrix) {
     solution(matrix);
     }
     public void solution(int[][] matrix) {
     if (matrix == null) {
     return;
     }
     for (int i = 0; i < matrix.length; i++) {
     for (int j = 0; j < matrix[0].length; j++) {
     dfs(matrix, i, j);
     }
     }

     //把标记改回来
     for (int i = 0; i < matrix.length; i++) {
     for (int j = 0; j < matrix[0].length; j++) {
     if (matrix[i][j] == Integer.MIN_VALUE/2) {
     matrix[i][j] = 0;
     }
     }
     }
     }

     void dfs(int[][] matrix,int i,int j) {

     if (matrix[i][j] != 0) {
     return;
     }
     else {
     matrix[i][j] = Integer.MIN_VALUE/2;
     //找到所在列所有为0的数
     for (int k = 0; k < matrix.length; k++) {
     if (matrix[k][j] == 0) {
     dfs(matrix, k, j);
     } else {
     matrix[k][j] = Integer.MIN_VALUE/2;
     }

     }
     //找到所在行所有为0的数
     for (int k = 0; k < matrix[0].length; k++) {
     if (matrix[i][k] == 0) {
     dfs(matrix, i, k);
     } else {
     matrix[i][k] = Integer.MIN_VALUE/2;
     }
     }
     }
     return;

     }
     }
     ```



     */

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        new SetMatrixZeroes().solution(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void solution(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(matrix, i, j);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == Integer.MIN_VALUE) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    void dfs(int[][] matrix,int i,int j) {

        if (matrix[i][j] != 0) {
            return;
        }
        else {
            matrix[i][j] = Integer.MIN_VALUE;
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][j] == 0) {
                    dfs(matrix, k, j);
                } else {
                    matrix[k][j] = Integer.MIN_VALUE;
                }

            }
            for (int k = 0; k < matrix[0].length; k++) {
                if (matrix[i][k] == 0) {
                    dfs(matrix, i, k);
                } else {
                    matrix[i][k] = Integer.MIN_VALUE;
                }
            }
        }
        return;

    }
}
