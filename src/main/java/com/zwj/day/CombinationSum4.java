package com.zwj.day;

import java.util.Arrays;

/**
 * @Author:zengwenjie
 * @Date:2021/4/24 9:55
 */
public class CombinationSum4 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        int result = new CombinationSum4().solution(nums, target);
        System.out.println(result);

    }
    int solution(int[] nums, int target) {
        int[][] dp = new int[nums.length+1][target+1];
        Arrays.fill(dp[0], 0);
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        int sum = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int _j = j;
                while (_j - nums[i-1] >= 0) {
                    dp[i][j] += dp[i - 1][_j-nums[i-1]];
                    _j -= nums[i-1];
                }
                dp[i][j] += dp[i - 1][j];
                sum += dp[i][j];

            }
        }

        return dp[nums.length][target];
    }
}
