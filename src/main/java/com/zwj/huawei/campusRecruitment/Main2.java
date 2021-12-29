    package com.zwj.huawei.campusRecruitment;


    import java.util.*;

    /***
     * description:
     * @param:
     * @return:
     * @author zwj
     * @date: 2021/5/12 15:00
     */
    public class Main2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {

                int serviceNums = scanner.nextInt();
                int startPost = scanner.nextInt();
                ArrayList<ArrayList<Integer>> map = new ArrayList<>();
                for (int i = 0; i < serviceNums; i++) {
                    map.add(new ArrayList<Integer>());
                }
                scanner.nextLine();
                for (int i = 0; i < serviceNums; i++) {
                    String s = scanner.nextLine();
                    String[] split = s.split(",");
                    if (Integer.parseInt(split[0]) > 0) {
                        for (int j = 1; j < split.length; j++) {
                            ArrayList arrayList = map.get(i);
                            arrayList.add(Integer.parseInt(split[j]));
                        }
                    }
                }
                ArrayList<ArrayList<Integer>> dependents = new ArrayList<>();

                int[] visited = new int[serviceNums];
                Arrays.fill(visited,0);
                boolean result = dfs(startPost, dependents, map, visited, 0);
                if (!result) {
                    System.out.println(-1);
                } else {
                    ArrayList<Integer> ansList = new ArrayList<>();
                    HashSet<Integer> started = new HashSet<>();
                    for (int i = dependents.size() - 1; i >= 0; i--) {
                        for (Integer integer : dependents.get(i)) {
                            if (!started.contains(integer)) {
                                ansList.add(integer);
                            }

                        }
                    }
                    String ans = ansList.toString();
                    System.out.println(ans.substring(1, ans.length() - 1));

                }



            }


        }

        public static boolean dfs(int pos, ArrayList<ArrayList<Integer>> dependents, ArrayList<ArrayList<Integer>> map,int[] visited,int deep) {
            if (visited[pos] == 0) {
                visited[pos] = 1;
            } else {
                return false;
            }
            if (deep + 1 > dependents.size()) {
                dependents.add(new ArrayList<Integer>());
            }
            ArrayList<Integer> dependList = dependents.get(deep);
            ArrayList<Integer> list = map.get(pos);
            for (Integer integer : list) {
                dependList.add(integer);
                boolean dfs = dfs(integer, dependents, map, visited, deep + 1);
                if (!dfs) {
                    return false;
                }
            }
            visited[pos] =2;
            return true;

        }
    }
