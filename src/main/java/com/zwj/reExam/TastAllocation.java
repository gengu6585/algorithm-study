package com.zwj.reExam;

import java.util.Arrays;

/*
 * @Author:zengwenjie
 * @Date:2021/4/7 10:33
 */
public class TastAllocation {
    public static void main(String[] args) {
        int[] tasks={0,1,2,0,10000,19999};
        if (new TastAllocation().solution(tasks)) {
            System.out.println("YES");
        }else System.out.println("No");
    }
    boolean solution(int tasks[]) {
        int taskCount=0;
        for (int i = 0; i < tasks.length; i++) {
            int taskNum=tasks[i];
            while (taskNum-- > 0) {
                taskCount+=i+1;
            }
        }
        if (taskCount % 2 == 1) {
            return false;
        }
        taskCount=taskCount/2;
        boolean [][]dp=new boolean[tasks.length+1][taskCount+1];
        dp[0][0]=false;
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0]=true;
        }
        for (int i = 1; i < tasks.length+1; i++) {
            for (int j =1; j < taskCount+1; j++) {
                int temp=tasks[i-1];
                if (!dp[i][j]) {
                    for (int k = 1; k <= temp; k++) {
                        if (j - k * i >= 0) {
                            if (dp[i][j - k * i]) {
                                dp[i][j]=true;
                                break;
                            }
                        }else break;
                    }
                }
            }
        }
        return dp[tasks.length][taskCount];
    }
}
