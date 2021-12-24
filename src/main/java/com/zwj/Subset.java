package com.zwj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author:zengwenjie
 * @Date:2021/3/2 14:19
 */
public class Subset {
    public static void main(String[] args) {
//        int nums[] = {10,1,2,7,6,1,5};
        int sum=0;
        int target=2;
        int nums[] = {1,1,2,2,2};
//        int nums[] = {8, 2,2,4,4};
//        int nums[] = {8, 2,2,4,4,1,16,9,7,8,2,14,4,4,3,3,3,1};

        MyDeque item = new MyDeque();
        HashSet<MyDeque> results = new HashSet<>();
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum < target) {
            return;
        }
        new Subset().solution(0,nums,item,results,target);
//        new WriteToFile().write(results.toString());

        for (MyDeque result : results) {
            out.add(result);
        }
        System.out.println(out.toString());


    }

        void solution(int i,int nums[] ,MyDeque item ,HashSet<MyDeque> result,int diff ) {
            if (i >nums.length-1||diff<0) {
                return;
            }

            item.add(nums[i]);
            solution(i+1,nums,item,result,diff-nums[i]);
            if (diff-nums[i] == 0) {
                result.add((MyDeque) item.clone());
            }
            item.remove(item.size()-1);
            solution(i+1,nums,item,result,diff);
            return ;
        }
}
