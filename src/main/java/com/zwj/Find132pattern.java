package com.zwj;

import java.util.ArrayDeque;

/***
 * description: 132模式（使用单调栈，第一次见到！）
 * @param: LeetCodeLink：https://leetcode-cn.com/problems/132-pattern/
 * @return: 
 * @author zwj
 * @date: 2021/3/27 22:54
 */
public class Find132pattern {
    boolean solution(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length <= 3) {
            return false;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int secondNum = Integer.MIN_VALUE;
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] < secondNum) {
                return true;
            }
            while (stack.size() != 0 && nums[i] > stack.peek()) {
                secondNum = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
