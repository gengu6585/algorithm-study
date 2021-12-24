package com.zwj.day;

import java.util.Arrays;

/***
 * description: 最多牌组数
 * LeetCodeLink:https://leetcode-cn.com/contest/season/2021-spring/problems/Up5XYM/
 * @param:
 * @return:
 * @author zwj
 * @date: 2021/5/5 10:43
 */


public class MaxGroupNumber {
    public static void main(String[] args) {
        int[] tiles = {1,2,2,2,3,3,4};
        int result = new MaxGroupNumber().solution(tiles);
        System.out.println(result);
    }
    int solution(int[] tiles) {
        Arrays.sort(tiles);
        int []dp=new int[tiles.length+1];
        dp[0]=1;
        dp[1]=0;
        dp[2]=0;

        System.out.println(Arrays.toString(dp));
        for(int i=3;i<dp.length;i++){
            //不构成排
            dp[i]=dp[i-1];
            //顺子
            int times=3;
            int pos=i;
            int add=0;
            int lastnum=tiles[i-1];
            int count=0;
            while(pos>=1&&times-->0){

                while(pos>=1&&tiles[pos-1]==lastnum){
                    pos--;
                    count++;
                }
                if(count==4){
                    add++;
                }
                if(count==0){
                    add=0;
                    break;
                }
                if(pos==0&&times>0){
                    add=0;
                }
                lastnum--;;
                count=0;
            }
            if (times == 0) {
                dp[i]=Math.max(dp[i],dp[pos]+add);
            }

            //对子
            boolean isDuizi=true;
            times=2;
            pos=i-1;
            while(times-->0){
                if(tiles[i-1]!=tiles[pos-1]){
                    isDuizi=false;
                    break;
                }
                pos--;
            }
            if(isDuizi){
                dp[i]=Math.max(dp[i],dp[i-3]);
            }




        }
        return dp[tiles.length];

    }

}
