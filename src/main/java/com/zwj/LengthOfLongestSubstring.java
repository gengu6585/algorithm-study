package com.zwj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

/**
 * @Author:zengwenjie
 * @Date:2021/3/7 21:43
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
//        a 97 A 65
        String s = "abcabcbb";
        int result = new LengthOfLongestSubstring().solution(s);
        System.out.println(result);

    }
    int solution(String s) {
//        int a = 97;
//        int b = 65;
//        HashSet<Character> set = new HashSet<>();
//        for (int i = 0; i < 26; i++) {
//            set.add(new Character((char) a++));
//            set.add(new Character((char) b++));
//        }
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        HashSet<Character> characters = new HashSet<>();
        int start = 0;
        int longestLength = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean bool = characters.add(new Character(s.charAt(i)));
            if (!bool) {
                int length = i - start;
                if (length > longestLength) {
                    longestLength = length;
                }
                while (s.charAt(start)!=s.charAt(i)) {
                    characters.remove(new Character(s.charAt(start)));
                    start++;
                }
                start++;
            }
            int length = i - start+1;
            if (length > longestLength) {
                longestLength = length;
            }
        }

        return longestLength;
    }
}
