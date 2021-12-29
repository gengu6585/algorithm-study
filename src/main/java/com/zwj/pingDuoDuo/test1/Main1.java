package com.zwj.pingDuoDuo.test1;

import java.util.ArrayList;
import java.util.Scanner;

/***
 * description:
 * @param:
 * @return:
 * @author zwj
 * @date: 2021/5/12 15:00
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            if (a > 55) {
                System.out.println(-1);
            } else {
                ArrayList<Integer> ans = new ArrayList<>();

            for (int i = 9; i >= 1; i--) {
                if (a - i >= 0) {
                    a -= i;
                    ans.add(i);
                }
            }
            if (a == 0) {
                ans.sort((b, c) -> b - c);
                StringBuilder result = new StringBuilder();
                for (Integer an : ans) {
                    result.append(an);
                }
                System.out.println(result.toString());
            } else {
                System.out.println(-1);
            }
            }



        }



    }
}
