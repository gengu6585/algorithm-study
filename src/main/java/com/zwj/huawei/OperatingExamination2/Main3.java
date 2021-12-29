package com.zwj.huawei.OperatingExamination2;

import java.util.Arrays;
import java.util.Scanner;

public class Main3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int[][] map = new int[19][];
            int times=19;
            for (int i = 0; i < times; i++) {
                String line = scanner.nextLine();
                int[] s = Arrays.stream(line.split(" ")).mapToInt(Integer::new).toArray();
                map[i] = s;

            }
            int white = getDp(1, map);
            int Black = getDp(2, map);

            System.out.println(white);
            System.out.println(Black);


        }



    }
    public static int getDp(int number,int [][]map){
        int[][] dp = new int[19][19];
        if (map[0][0] == number) {
            dp[0][0] = 1;
        }
        int ans = 0;
        for (int i = 1; i < 19; i++) {
            if (map[0][i - 1] == 1) {
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                dp[0][i] = 0;
            }
            ans = Math.max(dp[0][i], ans);
        }
        for (int i = 1; i < 19; i++) {
            if (map[i-1][0] == number) {
                dp[i][0] = dp[i-1][0] + 1;

            } else {
                dp[i][0] = 0;
            }
            ans = Math.max(dp[i][0], ans);
        }
        for (int i = 1; i < 19; i++) {
            for (int j = 1; j < 19; j++) {
                if (map[i][j] == number) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }
}

