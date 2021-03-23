package com.zwj;

import sun.plugin2.ipc.windows.WindowsIPCFactory;

import java.util.ArrayDeque;

/**
 * @Author:zengwenjie
 * @Date:2021/3/21 20:45
 */
public class DistinctSubsequences {
    int result;
    String s;
    String t;

    public static void main(String[] args) {
        String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
        t="bcddceeeebecbc";
        int result = new DistinctSubsequences().solution1(s, t);
        System.out.println(result);
    }
//动态规划
    int solution1(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        if (s.length() < t.length()) {
            return 0;
        }
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < t.length() + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < t.length()+1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
//回溯法，超时
    int solution(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        if (s.length() < t.length()) {
            return 0;
        }
        if (s.length() == t.length()) {
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return 1;
            } else {
                return 0;
            }
        }
        this.s = s;
        this.t = t;
        dfs(0,0);
        return this.result;
    }

    void dfs(int s_pos,int t_pos) {
        if (t_pos == t.length()) {
            this.result++;
            return;
        }
        while (s_pos<s.length()&&s.charAt(s_pos) != t.charAt(t_pos)) {
            s_pos++;
        }
        if (s_pos == s.length()) {
            return;
        }
        dfs(s_pos+1,t_pos+1);
        dfs(s_pos+1,t_pos);
    }

}
