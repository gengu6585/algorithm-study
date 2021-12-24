package com.zwj.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/***
 * description: 从键盘输入
 * @param:
 * @return:
 * @author zwj
 * @date: 2021/3/29 23:35
 */
public class SystemIn extends Thread{
    static Object o = new Object();
    static Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        fangfa();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new SystemIn().start();
        }






//        InputStreamReader read = new InputStreamReader(System.in);
//        BufferedReader buffRead = new BufferedReader(read);
//        try {
//            char c = (char) buffRead.read();
//            System.out.println(c);
//            System.out.println(buffRead.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    void fangfa() {
        synchronized (this.o) {
            o.notifyAll();
            int integer = 0;
            float floats = 0;
            while (integer == 0) {
                System.out.println("请输入一个整数");
                try {
                    integer = scanner.nextInt();
                } catch (RuntimeException e) {
                    System.out.println("请输入正确的整数");
                    scanner.nextLine();
                }
            }
            while (floats == 0) {
                System.out.println("请输入一个浮点数");
                try {
                    floats = scanner.nextFloat();
                } catch (RuntimeException e) {
                    System.out.println("请输入正确的浮点数");
                    try {
                        scanner.nextLine();
                    } catch (RuntimeException f) {
                        System.out.println(f.getMessage());

                    }
                }
                System.out.println("aaa");
//        }
            }
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
