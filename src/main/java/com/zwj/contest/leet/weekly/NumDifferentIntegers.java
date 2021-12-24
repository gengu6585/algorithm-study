package com.zwj.contest.leet.weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*** 
 * description: 字符串不同整数的数目
 * @param: LeetCodeLink:https://leetcode-cn.com/problems/number-of-different-integers-in-a-string/
 * @return:
 * @author zwj
 * @date: 2021/3/30 12:29
 */
public class NumDifferentIntegers {
    public static void main(String[] args) {
        String word = "a123b00003c34d8e000f03";
        int result = new NumDifferentIntegers().solution(word);
        System.out.println(result);
    }
        int solution(String word) {
            if (word == null) {
                return 0;
            }
            if (word.length() == 0) {
                return 0;
            }
        String[] split = word.split("[a-z]\\s*");
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                if (!split[i].equals("")) {
                    String trimed = trim(split[i]);
                    split[i] = trimed .equals("") ? "0": trimed;
                }
            }
            System.out.println(Arrays.toString(split));
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < split.length; i++) {
                if (!split[i].equals("")) {
                    set.add(split[i]);
                }
            }

            for (String s : set) {
                System.out.println(s);
            }
            return  set.size();
        }

        public String trim(String s) {
            char[] value = s.toCharArray();
            int len = value.length;
            int st = 0;
            char[] val = value;    /* avoid getfield opcode */

            while ((st < len) && (val[st] <= '0')) {
                st++;
            }
            return ((st > 0) || (len < value.length)) ? s.substring(st, len) : s;
        }
}
