package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/12 11:52
 */
public class DungeonGame {
    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int result = new DungeonGame().solution(dungeon);
        System.out.println(result);

    }
    int solution(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return -1;
        }
        int[][] minHp = new int[dungeon.length][dungeon[0].length];

        for (int i = dungeon.length-1; i >= 0; i--) {
            for (int j = dungeon[0].length-1; j >=0; j--) {
//                最右下的点;
                if (i==dungeon.length-1&&j==dungeon[0].length-1) {
                    minHp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                }
//                最下面一行
                else if (i == dungeon.length-1&&j!=dungeon[0].length-1) {
                    minHp[i][j] = Math.max(1, minHp[i][j + 1]-dungeon[i][j]);

                } else if (i != dungeon.length-1 && j == dungeon[0].length-1) {
                    minHp[i][j] = Math.max(1, minHp[i+1][j]-dungeon[i][j]);

                } else {
                    int min = Math.min(minHp[i + 1][j], minHp[i][j + 1]);
                    minHp[i][j] = Math.max(1,min-dungeon[i][j]);
                }


            }
        }
        return minHp[0][0];
    }

}
