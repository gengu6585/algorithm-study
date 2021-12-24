package com.zwj.contest.leet.weekly;

import com.sun.scenario.effect.impl.sw.java.JSWRendererDelegate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 * description: 替换括号的键
 * @param: LeetCodeLink：https://leetcode-cn.com/problems/evaluate-the-bracket-pairs-of-a-string/
 * @return:
 * @author zwj
 * @date: 2021/3/30 12:28
 */
public class EvaluateTheBracketPairsOfAString {
    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        StringBuilder ss = new StringBuilder(s);
        ss.replace(0, 5, "wangbadan");
        String solution = new EvaluateTheBracketPairsOfAString().solution(s, new ArrayList<List<String>>());
        System.out.println(solution);
    }
    String solution(String s, List<List<String>> knowledge) {
        if (s == null) {
            return null;
        }
        if (knowledge == null) {
            knowledge = new ArrayList<List<String>>();
        }
        StringBuilder ss = new StringBuilder(s);
        HashMap<String, String> map = new HashMap<>();
        for (List<String> stringList : knowledge) {
            map.put(stringList.get(0), stringList.get(1));
        }
        int left = -1;
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i) == '(') {
                left = i;
            }
            if (ss.charAt(i) == ')') {
                if (left != -1) {
                    String substring = ss.substring(left+1, i);
                    String relaceString = map.getOrDefault(substring, "?");
                    int off = relaceString.length() - substring.length() - 2;
                    ss.replace(left, i+1, map.getOrDefault(substring, "?"));
                    i += off;
                    left = -1;
                }
            }
        }
        return ss.toString();
    }


}
