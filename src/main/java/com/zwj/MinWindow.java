package com.zwj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Author:zengwenjie
 * @Date:2021/3/8 11:10
 */
public class MinWindow {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        int[] result = new MinWindow().solution(s, t);

        System.out.println(Arrays.toString(result));
        String substring = s.substring(result[0], result[1]+1);
        System.out.println(substring);
    }
    int[] solution(String s, String t) {
//        t字串的集合
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return null;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {

                map.put(t.charAt(i), map.get(t.charAt(i))+1);
            } else {
                map.put(t.charAt(i), 1);
            }

        }
        int win_start = 0;
        int win_end = 0;
        int result[] = new int[2];
        int count = 0;
        for (int i = 0; i < s.length() && count < t.length(); i++) {
            if (map.containsKey(s.charAt(i))) {

                Integer integer = map.get(s.charAt(i));
                if (count == 0) {
                    win_start = i;
                }
                map.put(s.charAt(i), integer - 1);
                if (integer <= 0) {
                    win_end = i;
                    continue;
                }
                count++;
                win_end = i;



            }
        }

        while (!map.containsKey(s.charAt(win_start))||map.get(s.charAt(win_start)) != 0) {
            if (!map.containsKey(s.charAt(win_start))) {
                if (win_start < win_end) {
                    win_start++;
                } else break;
            } else {
                if (map.get(s.charAt(win_start)) < 0) {
                    map.put(s.charAt(win_start), map.get(s.charAt(win_start)) + 1);
                }
                if (win_start < win_end) {
                    win_start++;
                }else break;

            }
        }
        boolean flag = true;
        for (Map.Entry<Character, Integer> characterEntry : map.entrySet()) {
            if (characterEntry.getValue()>0) {
                flag = false;
            }
        }
        if (flag) {
            result[0] = win_start;
            result[1] = win_end;
//            if (map.size() == 1) {
//                return result;
//            }

            while (win_end < s.length()) {
//                找到下一个等于起始点字符的位置

                if (win_end == s.length()-1) {
                    break;
                }
                win_end++;
                for (;win_end < s.length()&&s.charAt(win_end)!=s.charAt(win_start);win_end++) {
                    if (map.containsKey(s.charAt(win_end))) {
                    Integer integer = Math.abs(map.get(s.charAt(win_end)));
                    map.put(s.charAt(win_end),integer+1);
                    }
                }

                if (win_end == s.length()) {
                    return result;
                } else {

//                起始点开始移动，移动到下一个恰好包含所有字符的位置
                    win_start++;
                    while (win_start<win_end) {
                        if (map.containsKey(s.charAt(win_start))) {
                            Integer balance = Math.abs(map.get(s.charAt(win_start)));
                            if (balance > 0) {
                                Integer integer = Math.abs(map.get(s.charAt(win_start)));
                                map.put(s.charAt(win_start),integer-1);

                                win_start++;
                                continue;
                            } else{
                                break;
                            }

                        }
                        win_start++;
                    }
                    if (win_end - win_start < result[1] - result[0]) {
                        result[0] = win_start;
                        result[1] = win_end;
                    }

                }
            }
            return result;
        }

        return null;
    }
}
