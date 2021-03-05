package com.zwj;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zengwenjie
 * @Date:2021/3/3 13:53
 */
public class N_Queen {
    public static void main(String[] args) {
        int n = 5;
        List<StringBuilder> chessboard = new ArrayList<>(n);
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(".");
            }
            chessboard.add(row);
        }
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(chessboard.get(i).charAt(j) + "  ");
            }
            System.out.println("");
        }
        System.out.println("-----------------");
        new N_Queen().solution(0,chessboard,path,n,result);
        System.out.println(result.toString());


    }

    public void solution(int pos,List<StringBuilder> chessboard, ArrayList<Integer> path,int n,List<List<String>> result) {
        if (pos > n-1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(chessboard.get(i).charAt(j)+"  ");
                }
                System.out.println("");
            }
            ArrayList<String> _chessboard = new ArrayList<>();

            for (StringBuilder stringBuilder : chessboard) {
                _chessboard.add(stringBuilder.toString());
            }
            result.add(_chessboard);
            System.out.println("-------------");

            return;
        }
        for (int i = 0; i < n; i++) {
            if (path.contains(i)) {
                continue;
            }
            boolean flag = true;
            if (pos != 0) {

                for (int j = 0; j < path.size(); j++) {
                    if (Math.abs(j-pos) == Math.abs(i - path.get(j))) {
                        flag = false;
                    }
                }
            }
            if (!flag) {
                continue;
            }
            path.add(i);
            chessboard.get(pos).setCharAt(i, 'Q');
            solution(pos+1,chessboard, path,n,result);
            if (path.size() != 0) {
                path.remove(path.indexOf(i));
            }
            chessboard.get(pos).setCharAt(i, '.'); ;


        }
    }
}
