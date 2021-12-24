package com.zwj.day;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zengwenjie
 * @Date:2021/4/24 0:00
 */
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {1,2,4,8};
        List<Integer>  result = new LargestDivisibleSubset().solution(nums);
        System.out.println(result.toString());


    }
    List<Integer> solution(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        int ans = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] >= ans) {
                index = i;
                ans = dp[i];
            }
        }
        int maxValue = nums[index];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = index; i >= 0; i--) {

            if (maxValue % nums[i] == 0 && dp[i] == ans) {
                res.add(nums[i]);
                maxValue = nums[i];
                ans--;
            }



        }


        return res ;
    }
}
