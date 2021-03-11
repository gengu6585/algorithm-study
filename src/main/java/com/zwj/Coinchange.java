package com.zwj;

import java.util.Arrays;

/**
 * @Author:zengwenjie
 * @Date:2021/3/11 18:37
 */
public class Coinchange {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5, 7, 10};
        int amount = 14;
        for (int i = 0; i < 15; i++) {
            int result = new Coinchange().solution(coins, i);
            System.out.println(i+"------------"+result);
        }

    }
    int solution(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }
        if (coins.length == 0||amount<=0) {
            return -1;
        }

        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    if (dp[i]==-1||dp[i-coins[j]]+1<dp[i]) {
                        dp[i]= dp[i-coins[j]]+1;
                    }
                }
                }
        }
        return dp[amount];
    }
}
