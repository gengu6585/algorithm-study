package com.zwj.day;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author:zengwenjie
 * @Date:2021/6/5 19:46
 */
public class ContiguousArray0_1 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,0,0,0,1};
        int result = new ContiguousArray0_1().solution(nums);
        System.out.println(result);
    }

    int solution(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 0) {
            return 0;
        }
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,-1);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count+=1;
            }else{
                count+=-1;
            }
            if (map.containsKey(count)) {
                Integer pos = map.get(count);
                ans = Math.max(ans, i - pos);
            } else {
                map.put(count, i);
            }


        }


        return ans;
    }
}
