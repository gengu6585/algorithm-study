    package com.zwj.huawei.OperatingExamination2;


    import java.util.*;

    /**
     * @Author:zengwenjie
     * @Date:2021/4/27 17:57
     */
    public class Main2 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                int times = n;
                int[] cost = new int[n];
                int[] inner = new int[n];
                List<Integer>[] map = new ArrayList[n];
                for (int i = 0; i < map.length; i++) {
                    map[i]=new ArrayList<Integer>();
                }
                scanner.nextLine();
                int start = 0;
                while (times-- > 0) {
                    String line = scanner.nextLine();
                    String[] split = line.split(" ");
                    cost[start] = Integer.valueOf(split[1]);
                    int length = split.length;
                    while (length - 2 > 0) {
                        map[start].add(Integer.valueOf(split[length - 1]));
                        inner[Integer.valueOf(split[length - 1])]++;
                        length--;
                    }
                    start++;

                }

                Ans ans = new Ans();
                for (int i = 0; i < inner.length; i++) {
                    if (inner[i] == 0) {
                        dfs(i, map, cost, ans, cost[i]);
                    }
                }

                System.out.println(ans.result);
            }


        }
        public static class Ans{
            public Ans() {

            }
            int result=0;
        }

        public static void dfs(int pos,List<Integer>[]map,int[]cost,Ans ans,int length) {
            List<Integer> list = map[pos];
            if (list.size() == 0) {
                if (length > ans.result) {
                    ans.result = length;
                    return;
                }
            }
            for (Integer integer : list) {
                dfs(integer, map, cost, ans, length + cost[integer]);
            }

        }
    }
