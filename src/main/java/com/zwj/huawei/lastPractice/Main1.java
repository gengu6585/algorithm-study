package com.zwj.huawei.lastPractice;

import org.omg.CORBA.INTERNAL;

import java.util.Scanner;
import java.util.*;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            HashSet<Integer>[] map=new HashSet[a];
            for (int i = 0; i < a; i++) {
                map[i] = new HashSet<>();
            }
            int[] to=new int[a];
            ArrayList<Integer> ans=new ArrayList();
            while(b-->0){

                int winner=in.nextInt();
                int loser=in.nextInt();

                if(!map[winner-1].contains(loser-1)){
                    map[winner-1].add(loser-1);
                    to[loser-1]++;
                }
            }
                while(true){
                    boolean flag=false;
                    for(int i=0;i<a;i++){

                        if(to[i]==0){
                            flag=true;
                            ans.add(i+1);
                            for (Iterator it = map[i].iterator(); it.hasNext(); ) {
                                to[(int)it.next()]--;
                            }
                            to[i] = Integer.MAX_VALUE;
                            break;
                        }
                    }
                    if(!flag){
                        break;
                    }
                }
                for(int i=0;i<ans.size()-1;i++){
                    System.out.print(ans.get(i)+" ");
                }
                System.out.print(ans.get(ans.size()-1));
            System.out.println();


        }
    }
}