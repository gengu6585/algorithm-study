package com.zwj.contest.leet.weekly;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @Author:zengwenjie
 * @Date:2021/8/10 10:26
 */
public class Problem {
    public static void main(String[] args) {
        String s="you(love)I";
        int pos=s.length()-1;
        ArrayList<String> result = new ArrayList<>();
        while(pos>=0){
            StringBuilder ss = new StringBuilder();
            if (s.charAt(pos) == ')') {
                pos--;
                while (s.charAt(pos) != '(') {
                    ss.append(s.charAt(pos));
                    pos--;
                }

                result.add(ss.reverse().toString());
                pos--;
            } else {
                while (pos>=0&&s.charAt(pos)!=')') {
                    ss.append(s.charAt(pos));
                    pos--;
                }
                result.add(ss.reverse().toString());

            }
        }

        while (result.size() != 0) {
            System.out.print(result.remove(0)+' ');
        }
    }
}
