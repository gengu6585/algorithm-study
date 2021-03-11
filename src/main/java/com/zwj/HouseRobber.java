package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/11 17:07
 */
public class HouseRobber {
    public static void main(String[] args) {
//        int[] nums = {2, 7, 9, 3, 1};
        int[] nums = {1,2,3,1};
        int result = new HouseRobber().solution(nums);
        System.out.println(result);
    }

    int solution(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int []dp = new int[nums.length];
        boolean flag = true;
        dp[0] = nums[0];
        if (nums[0] < nums[1]) {
            dp[1] = nums[1];
            flag = true;
        } else {
            dp[1] = nums[0];
            flag = false;
        }
        for (int i = 2; i < nums.length; i++) {
            if (flag == true) {
                if (dp[i - 2] + nums[i] > dp[i - 1]) {
                    dp[i] = dp[i - 2] + nums[i];
                    flag = true;
                } else {
                    dp[i] = dp[i - 1];
                    flag = false;
                }
            } else {
                dp[i] = dp[i - 1] + nums[i];
                flag = true;
            }
        }

        return dp[nums.length-1];
    }

}
