package com.zwj;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author:zengwenjie
 * @Date:2021/3/24 9:22
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {
    public static void main(String[] args) {
        String s = "dyyuyabzkqaybcspq";
        int reuslt = new MinimumInsertionStepsToMakeAStringPalindrome().solution(s);
        System.out.println(reuslt);
    }
    int solution(String s) {
        if (s == null) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        HashMap<Character, ArrayList> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(s.charAt(i), list);
            }else {
                ArrayList list = map.get(s.charAt(i));
                list.add(i);
                map.put(s.charAt(i), list);
            }
        }
        Set<Map.Entry<Character, ArrayList>> entries = map.entrySet();
        ArrayList<Pair> pairs = new ArrayList<>();
        for (Map.Entry<Character, ArrayList> entry : entries) {
            ArrayList list = entry.getValue();
            if (list.size() > 1) {
                int start = 0;
                int end = list.size() - 1;
                while (start<end){
                    pairs.add(new Pair<Integer, Integer>((Integer) list.get(start), (Integer)list.get(end)));
                    start++;
                    end--;
                }

            }
        }
        int[] mark = new int[s.length()];
        for (Pair pair : pairs) {
            int num1 = (int) pair.getKey();
            int num2 = (int) pair.getValue();
            for (int i = num1; i <= num2; i++) {
                mark[i] = mark[i] + 1;
            }
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] >= max) {
                if (mark[i] == max) {
                    count++;
                } else {
                    count = 0;
                    max = mark[i];
                }
            }
        }
        if (count == 1) {
            return s.length() - 1 - max * 2 + 1;
        }

        return s.length()-1-max*2;
    }
}
