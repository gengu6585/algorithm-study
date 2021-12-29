    package com.zwj.huawei.simulateTest;


    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.HashSet;
    import java.util.Scanner;

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
                String line = scanner.nextLine();
                System.out.println("in"+line);
                HashSet<Character> set = new HashSet<>();
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (!set.contains(c)) {
                        set.add(c);
                        ans.append(c);
                    }
                }
                System.out.println(ans.toString());

            }


        }

    }
