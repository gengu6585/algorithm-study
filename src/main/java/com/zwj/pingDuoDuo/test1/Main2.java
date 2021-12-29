    package com.zwj.pingDuoDuo.test1;


    import com.sun.deploy.util.ArrayUtil;

    import java.util.*;
    import java.util.stream.Stream;

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
                int l = scanner.nextInt();
                String stringA = scanner.next();
                String stringB = scanner.next();
                char[] charsA = stringA.toCharArray();
                Character[] charactersA = stringA.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
                Character[] charactersB = stringB.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
                List<Character> listA = Arrays.asList(charactersA);
                List<Character> listB = Arrays.asList(charactersB);
                listA.sort((a, b) -> a - b);
                listB.sort((a, b) -> a - b);
                int ans = 0;
                for (int i = 0; i < listA.size(); i++) {
                    ans += Math.abs(listA.get(i) - listB.get(i));
                }
                System.out.println(ans);


            }

    }


    }
