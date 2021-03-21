package com.zwj;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zengwenjie
 * @Date:3/15/2021 9:59 PM
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List result = new SpiralOrder().solution(matrix);
        System.out.println(result);
    }
    List solution(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int floor = 0;
        int west = 0;
        int east = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int i = floor;
        int j = west;
        ArrayList<Integer> result = new ArrayList<>();
        while (true) {
            while (j < east) {
                result.add(matrix[i][j]);
                j++;
            }
            floor++;
            if (i == bottom) {
                result.add(matrix[i][j]);
                break;
            }
            while (i < bottom) {
                result.add(matrix[i][j]);
                i++;
            }
            east--;
            if (j == west) {
                result.add(matrix[i][j]);
                break;
            }
            while (j > west) {
                result.add(matrix[i][j]);
                j--;
            }
            bottom--;
            if (i == floor) {
                result.add(matrix[i][j]);
                break;
            }
            while (i > floor) {
                result.add(matrix[i][j]);
                i--;
            }
            west++;
            if (j == east) {
                result.add(matrix[i][j]);
                break;
            }
        }
        return result;
    }

}
