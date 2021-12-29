package com.zwj.huawei.simulateTest;

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
            try {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println(a + b);
            } catch (RuntimeException e) {
                System.out.println("error");
                scanner.nextLine();
            }

        }



    }
}
