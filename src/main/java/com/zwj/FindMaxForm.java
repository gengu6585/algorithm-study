package com.zwj;

import java.util.ArrayList;

/**
 * @Author:zengwenjie
 * @Date:3/15/2021 11:28 PM
 */
public class FindMaxForm {
    public static void main(String[] args) {

        String strs[] = {"10","0001","111001","1","0"};
        int m = 3;
        int n = 4;
        int result = new FindMaxForm().findMaxForm(strs, m, n);
        System.out.println(result);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }
    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - '0']++;
        }
        return c;
    }


    int solution(String[] strs, int m, int n) {
        if (strs == null) {
            return 0;
        }
        if (strs.length == 0) {
            return 0;
        }
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] statics = new int[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            int[] array = new int[2];
            int zero_count = 0;
            int one_count = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    zero_count++;
                } else {
                    one_count++;
                }
            }
            array[0] = zero_count;
            array[1] = one_count;
            statics[i] = array;
        }
        ArrayList<int[]> dp = new ArrayList<>();

//        设置第一个集合
        if (m >= statics[0][0] && n >= statics[0][1]) {
            int[] array = new int[3];
            array[0] = m - statics[0][0];
            array[1] = n - statics[0][1];
            array[2] = 1;
            dp.add(array);
        } else {
            int[] array = new int[3];
            array[0] = -1;
            array[1] = -1;
            array[2] = 0;
            dp.add(array);
        }

        for (int i = 1; i < statics.length; i++) {
            if (m>=statics[i][0] && n >=statics[i][1]) {
                int[] max = new int[3];
                int size = dp.size();
                for (int j = 0; j < size; j++) {
                    if (dp.get(j)[0] >= statics[i][0] && dp.get(j)[1] >= statics[i][1]) {
                        if (dp.get(j)[2]+1 >= max[2]) {
                            max[0] = dp.get(j)[0] - statics[i][0];
                            max[1] = dp.get(j)[1] - statics[i][1];
                            max[2] = dp.get(j)[2] + 1;
                            dp.add(max.clone());
                        }
                    }
                }
                if (max[2] == 0) {
                    int[] array = new int[3];
                    array[0] = m - statics[i][0];
                    array[1] = n - statics[i][1];
                    array[2] = 1;
                    dp.add(array);
                }
            }else {
                int[] array = new int[3];
                array[0] = -1;
                array[1] = -1;
                array[2] = 0;
                dp.add(array);
            }
        }
        int max = 0;
        for (int[] ints : dp) {
            if (ints[2] > max) {
                max = ints[2];
            }
        }
        return max;

    }
}
