package com.zwj;

import java.util.ArrayList;

/**
 * @Author:zengwenjie
 * @Date:3/16/2021 11:58 AM
 */
public class BagProblem {
    public static void main(String[] args) {
        int[][] items = new int[][]{{2, 3}, {3, 4}, {4, 5}, {5, 6}};
        int capacity = 8;
        int result = new BagProblem().solution(items,capacity);
        System.out.println(result);
    }
    int solution(int[][] items,int capacity) {
        int[] dp = new int[capacity+1];
        dp[0] = 0;
        ArrayList<Integer> bagItems = new ArrayList<>();

        for (int i = 1; i < dp.length; i++) {
            int maxValue = 0;
            int itemNum = -1;
            for (int j = 0; j < items.length; j++) {

                int pos = i - items[j][0];
                if (pos < 0) {
                    continue;
                }
                if (dp[pos] + items[j][1] > maxValue) {
                    maxValue = dp[pos] + items[j][1];
                    itemNum = j;
                }

            }
            if (maxValue == 0) {
                dp[i] = 0;
            } else {
                dp[i] = maxValue;
            }
        }
        System.out.println(bagItems);
        return dp[capacity];
    }
}
