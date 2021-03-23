package com.zwj;

import java.util.ArrayList;
import java.util.List;

/***
 * description: 位1的个数,easy题
 * LeetCodeLink:https://leetcode-cn.com/problems/number-of-1-bits/
 * @return:
 * @author zwj
 * @date: 2021/3/22 10:54
 */
public class NumberOfOneBits {
    public static void main(String[] args) {
        int result = new NumberOfOneBits().solution(15);
        System.out.println(result);
    }



    int solution(int number) {
        int count = 0;
        int index = 0;
        while (index<32){
            if (((number>>index)&1)==1){
                count++;

            }
            index++;
        }
        return count;
    }
}
