package com.zwj.day;

import org.omg.CORBA.INTERNAL;

import java.nio.charset.CharacterCodingException;
import java.util.HashMap;

/**
 * @Author:zengwenjie
 * @Date:2021/4/21 13:19
 */
public class DecodeWays {
    public static void main(String[] args) {

        int result = new DecodeWays().solution("226");
        System.out.println(result);

    }
    int solution(String s) {

        if (s == null) {
            return 0;
        }
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        if (s.charAt(0) == '0') {
            return 0;
        } else {
            dp[1]=1;
        }
        for (int i = 2 ;i < dp.length; i++) {
            dp[i] = 0;
            Integer integer = Integer.valueOf(s.substring(i - 2, i));
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
                if (s.charAt(i - 2) == '0') {
                    continue;
                } else {
                    if (integer >= 1 && integer <= 26) {
                        dp[i] += dp[i - 2];
                    }
                }
            } else {
                if (s.charAt(i - 2) == '0') {
                    return 0;
                } else {
                    if (integer >= 1 && integer <= 26) {
                        dp[i] += dp[i - 2];
                    }
                }
            }


        }
        return dp[s.length()];
    }
}
