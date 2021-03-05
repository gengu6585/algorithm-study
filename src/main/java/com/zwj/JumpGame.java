package com.zwj;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @Author:zengwenjie
 * @Date:2021/3/1 17:32
 */
public class JumpGame {
    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
//        int[] nums = {3, 2, 1, 0, 4};
        String result = new JumpGame().maxJumpPath(nums);
        System.out.println("跳跃数组为------"+ Arrays.toString(nums));
        System.out.println("从0位置跳到最后一个元素的路径为-----"+result);

    }
//    int nums[] = {2, 3, 1, 1, 4};
    String maxJumpPath(int [] nums) {
        int pos = 1;
        ArrayDeque<Integer> path = new ArrayDeque<>();
        path.add(pos);
        while (pos + nums[pos - 1] < nums.length) {
            int maxLength = pos + nums[pos - 1]+nums[pos + nums[pos - 1]-1];
            int nextPos = pos + nums[pos - 1];
            for (int i = pos + nums[pos - 1]-1; i >pos; i--) {
                if (nums[i-1]+i > maxLength) {
                    maxLength = nums[i-1]+i;
                    nextPos = i;
                }
            }
            pos = nextPos;
            path.add(pos);
            if (nums[pos - 1] == 0) return "无法找到路径";
        }
        path.add(nums.length);
        return path.toString();
    }
}
