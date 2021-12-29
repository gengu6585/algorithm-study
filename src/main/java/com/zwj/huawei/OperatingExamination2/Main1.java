package com.zwj.huawei.OperatingExamination2;

import java.util.*;

/**
 * @Author:zengwenjie
 * @Date:2021/4/27 16:59
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int times=n;
            HashSet<String> set=new HashSet<String>();
            String[][]relation=new String[n][2];
            int index=0;
            scanner.nextLine();
            while(times-->0){
                String line = scanner.nextLine();
                String[] split = line.split(" ");
                for (String s : split) {
                    set.add(s);
                }
                relation[index++]=split;
            }
            ArrayList<String> list = new ArrayList<>();
            for (String s : set) {
                list.add(s);
            }
            HashMap<String, List<String>> map = new HashMap<String, List<String>>();
            for (String s : list) {
                map.put(s, new ArrayList<String>());
            }
            for (String[] strings : relation) {
                map.get(strings[1]).add(strings[0]);
            }
            String start = scanner.next();
            ArrayList<String> path = new ArrayList<>();
            ArrayList<String> ans = new ArrayList();
            dfs(start, map, path, ans);

            ans.sort((a,b)->{
                int l1=a.length();
                int l2=a.length();
                for (int i = 0; i < Math.min(l1, l2); i++) {
                    if (a.charAt(i) - b.charAt(i) > 0) {
                        return 1;
                    } else if (a.charAt(i) - b.charAt(i) < 0) {
                        return -1;
                    }
                }
                return l2>l1?1:-1;
            });
            for (String an : ans) {
                System.out.println(an);
            }
        }


    }
    public static void dfs(String s,HashMap<String, List<String>> map,List<String> path,List<String>ans){
        path.add(s);
        List<String> list = map.get(s);
        if (list.size() == 0) {
            String out = "";
            for(int i=path.size()-1;i>=0;i--){
                out=out+path.get(i)+".";
            }

            out = out.substring(0, out.length()-1);
            ans.add(out);
        }
        for (String s1 : list) {
            dfs(s1, map, path, ans);
        }
        path.remove(path.size() - 1);


    }
}
