package com.zwj.huawei.OperatingExamination;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author:zengwenjie
 * @Date:2021/4/27 16:59
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            ArrayList<Integer> scores = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                scores.add(scanner.nextInt());
            }
            scanner.nextLine();
            for (int i = 0; i < m; i++) {
                String s = scanner.nextLine();
                String ss = s.trim();
                String[] split = ss.split(" ");
                if (split[0].equals("Q")) {
                    int max = 0;
                    int j1=Integer.valueOf(split[1])-1;
                    int j2=Integer.valueOf(split[2])-1;
                    for (int j = Math.min(j1,j2); j <= Math.max(j1,j2); j++) {
                        max = Math.max(max, scores.get(j));
                    }
                    System.out.println(max);
                } else {
                    scores.set(Integer.valueOf(split[1])-1,Integer.valueOf(split[2]));
                }
            }
        }
    }
}
