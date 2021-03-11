package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/11 16:15
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int result = new ClimbStairs().solution(4);
        System.out.println(result);
    }
    int solution(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0]=1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
