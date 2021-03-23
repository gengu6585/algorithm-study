package com.zwj;

import javafx.util.Pair;

import java.util.ArrayList;

/***
 * description: 正则表达式的匹配
 * LeetCodeLink:https://leetcode-cn.com/problems/regular-expression-matching/
 * @author zwj
 * @date: 2021/3/23 15:42
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "mississippi" ,p = "mis*is*ip*.";
        boolean result = new RegularExpressionMatching().solution(s, p);
        System.out.println(result);
    }
    public boolean solution(String s, String p) {
        ArrayList<Pair> pList = null;
        if (s == null || p == null) {
            if (p != null) {
                pList = toPatternList(p);
                for (Object o : pList) {
                    Pair<Character, Boolean> o1 = (Pair<Character, Boolean>) o;
                    if (!o1.getValue()) {
                        return false;
                    }
                }
            }
            return true;
        }

        pList = toPatternList(p);
        Boolean[][] dp = new Boolean[s.length() + 1][pList.size() + 1];
        dp[0][0] = true;
        for (int i = 1; i < pList.size()+1; i++) {
            if ((Boolean) pList.get(i-1).getValue()) {
                dp[0][i] = dp[0][i - 1];
            } else dp[0][i] = false;
        }
        for (int i = 1; i < s.length()+1; i++) {
            dp[i][0]=false;
        }

        for (int j = 1; j < pList.size()+1; j++) {
            for (int i = 1; i < s.length() + 1; i++) {
                if ((Character) pList.get(j-1).getKey() == s.charAt(i-1) && !((Boolean) pList.get(j-1).getValue())) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if ((Character) pList.get(j-1).getKey() != s.charAt(i-1) && !((Boolean) pList.get(j-1).getValue())) {
                    if ((Character) pList.get(j-1).getKey()=='.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }else dp[i][j]=false;
                }
                //当碰到模糊匹配符时，
                // 如果是a~z *,找到dp[i-k][j-1]，为s中字符不是a~z的点，找到设置为该点的值，若知道s为空才找到，则直接返回true
                //如果是· *，找到dp[i-k][j-1]中第一个不为false的点，如果没找到则为false
                //最后返回dp最右下角的布尔值
                if ((Character)pList.get(j-1).getKey()==s.charAt(i-1)&&(Boolean) pList.get(j-1).getValue()) {
                    dp[i][j] = false;
                    boolean flag = false;
                    for (int k = i; k >=1; k--) {
                        if (s.charAt(k - 1) == (Character) pList.get(j - 1).getKey()) {
                            if (dp[k][j - 1]) {
                                dp[i][j] = dp[k][j - 1];
                                break;
                            }
                        } else {
                            flag = true;
                            dp[i][j] = dp[k][j - 1];
                            break;
                        }
                    }
                    if (!flag&& !dp[i][j]) {
                        dp[i][j] = dp[0][j - 1];
                    }
                }
                if ((Character) pList.get(j-1).getKey() == '.' && (Boolean) pList.get(j-1).getValue()) {
                    dp[i][j] = false;
                    for (int k = i; k >= 0; k--) {
                        if (dp[k][j-1]) {
                            dp[i][j] =dp[k][j - 1];
                            break;
                        }
                    }
                }
                if ((Character) pList.get(j - 1).getKey() != s.charAt(i - 1)&&(Character) pList.get(j-1).getKey() != '.' && (Boolean) pList.get(j - 1).getValue()) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][pList.size()];
    }

    ArrayList<Pair> toPatternList(String p) {
        ArrayList<Pair> pList = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            if ((int) ('a') <= (int) p.charAt(i) && p.charAt(i) <= (int) ('z')) {
                pList.add(new Pair<Character, Boolean>(p.charAt(i),false));
            }
            if (p.charAt(i) == '.') {
                pList.add(new Pair<Character, Boolean>('.',false));
            }
            if (p.charAt(i) == '*') {
                Pair last = pList.remove(pList.size() - 1);
                pList.add(new Pair<Character, Boolean>((Character) last.getKey(), true));
            }
        }
        return pList;
    }
}
