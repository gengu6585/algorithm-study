package com.zwj.huawei.problemSet;

import java.util.*;

/**
 * @Author:zengwenjie
 * @Date:2021/5/12 16:10
 */
public class Main1 {
    static int length;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        List<String> res = new ArrayList<>();

        while (scanner.hasNext()) {
            String s = scanner.next();
            length = s.length();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = new String(chars);
            dfs(s,set, list, 0,res);

            HashSet<String> stringSet = new HashSet<>();
            ArrayList<String> ans = new ArrayList<>();
            for (String re : res) {
                if (!stringSet.contains(re)) {
                    stringSet.add(re);
                    ans.add(re);
                }
            }
            System.out.println(ans);



        }
    }

    public static void dfs(String s,HashSet<Integer> set,List<Character> list, int deep,List<String> res) {
        if (deep == length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : list) {
                stringBuilder.append(character);
            }
            res.add(stringBuilder.toString());
        }
        for (int i = 0; i < length; i++) {
            if (!set.contains(i)) {
                set.add(i);
                list.add(s.charAt(i));
                dfs(s, set, list, deep + 1,res);
                list.remove(list.size() - 1);
                set.remove(i);

            }

        }
    }
}
