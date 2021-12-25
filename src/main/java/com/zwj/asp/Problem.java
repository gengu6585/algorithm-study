package com.zwj.asp;

import java.util.*;

/**
 * @Author:zengwenjie
 * @Date:2021-12-24 13:05
 */
public class Problem extends  Thread {
    static int solutionNums = 0;
    int runningPatter;
    int []row1;
    int []row2;
    int[] _row2;
    int [][] limitOfRow1;
    int [][] limitOfRow2;
    int r;
    int m;
    boolean flag;
    static Object object = new Object();

    public Problem(int m,int runningPatter) {
        this.runningPatter = runningPatter;
        init(m);
    }

    void init(int m) {
        this.m=m;
        row1 = new int[m];
        r=(m-1)/2;
        for (int i = 0; i < m; i++) {
            row1[i]=-r+i;
        }
        row2 = new int[m];
        _row2 = new int[m];
        //flag初始化为false表示为找到三行序列
        flag = false;
        //初始化limit数组
        limitOfRow1 = new int[m][2];
        limitOfRow2 = new int[m][2];

    }
    public void fintRow2ByFormula(int m){
        int r=(m-1)/2;
        //按照公式从左往右生成第二行
        row2[0] = row1[0];
        for (int i = 0; i < r; i++) {
            row2[2*i+1] = row1[r + 1+i];
            row2[2*i + 2] = row1[1 + i];
        }
        //按照公式从右往左生成第二行
        _row2[m-1] = row1[m-1];
        for (int i = 0; i < r; i++) {
            _row2[m-2*i-2] = row1[r -1-i];
            _row2[m-2*i - 3] = row1[m-2 - i];
        }
        generateLimit(2);
        findRow3(m);
        row2 = _row2;
        generateLimit(2);
        findRow3(m);
    }



    public  void findRow3(int m) {
        int[] queen = new int[m];
        Arrays.fill(queen, 0);
        int row=0;
        queen[row] = limitOfRow2[row][0];
        while (row>=0) {
            if (solutionNums >= 3) {
                System.out.println("查找结束");
                return;
            }
            if (row < m && queen[row] <= limitOfRow2[row][1]) {
                if (!judgeRow3(queen, row)) {
                    queen[row]++;
                } else {
                    row++;
                    if (row >= m) {
                        continue;
                    }
                    queen[row] = limitOfRow2[row][0];
                }
            } else {
                if (row >= m) {
                    flag=true;
                    solutionNums++;

                    int[] row3 = new int[row1.length];
                    for (int i = 0; i < row1.length; i++) {
                        row3[i] = row1[queen[i]];
                    }
                    System.out.println("当m=" +m+"时，runningPattern:"+runningPatter+
                            ",找到一组解：");
                    System.out.println("row1: "+ Arrays.toString(row1));
                    System.out.println("row2: "+ Arrays.toString(row2));
                    System.out.println("row3: " + Arrays.toString(row3));

                }
                row--;
                if (row < 0) {
                    break;
                }
                queen[row]++;

            }
        }
        if (!flag) {
            System.out.println("不存在");
        }

    }
    public  void findRow2(int m) {
        int[] queen = new int[m];
        Arrays.fill(queen, 0);
        int row=0;
        queen[row] = limitOfRow1[row][0];
        while (row>=0) {
            if (solutionNums >= 3) {
                return;
            }
            if (row < m && queen[row] <= limitOfRow1[row][1]) {
                if (!judgeRow2(queen, row)) {
                    queen[row]++;
                } else {
                    row++;
                    if (row >= m) {
                        continue;
                    }
                    queen[row] = limitOfRow1[row][0];
                }
            } else {
                if (row >= m) {
                    for (int i = 0; i < row1.length; i++) {
                        row2[i] = row1[queen[i]];
                    }
                    generateLimit(2);
                    findRow3(m);
                }
                row--;
                if (row < 0) {
                    break;
                }
                queen[row]++;

            }
        }
        if (!flag) {
            System.out.println("未找到");
        }
    }
    public boolean judgeRow3(int []queen, int row) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i <=row; i++) {
            if (i!=row&&queen[i] == queen[row]) {
                return false;
            }
            if (set1.contains(row1[i] - row1[queen[i]]) || set2.contains(row2[i] - row1[queen[i]])) {
                return false;
            }
            set1.add(row1[i] - row1[queen[i]]);
            set2.add(row2[i] - row1[queen[i]]);
        }
        return true;
    }
    public boolean judgeRow2(int []queen, int row) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i <=row; i++) {
            if (i!=row&&queen[i] == queen[row]) {
                return false;
            }
            if (set1.contains(row1[i] - row1[queen[i]])) {
                return false;
            }
            set1.add(row1[i] - row1[queen[i]]);
        }
        return true;
    }

    public void solution(int m) {
        solutionNums = 0;
        if (runningPatter == 3) {
            fintRow2ByFormula(m);
        } else {
            generateLimit(1);
            findRow2(m);
        }
    }
    void generateLimit(int row) {
        if (row == 1) {
            for (int i = 0; i < limitOfRow1.length; i++) {
                limitOfRow1[i][0] = Math.max(row1[i] - r, -r)+r;
                limitOfRow1[i][1] = Math.min(row1[i] + r, r)+r;
            }
        } else if (row == 2) {
            for (int i = 0; i < limitOfRow2.length; i++) {
                limitOfRow2[i][0] = Math.max(Math.max(row1[i] - r, -r), Math.max(row2[i] - r, -r))+r;
                limitOfRow2[i][1] = Math.min(Math.min(row1[i] + r, r), Math.min(row2[i] + r, r))+r;
            }

        }
    }
    @Override
    public void run() {
        solution(m);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
//            new Problem(m,1).solution(m);
//            new Problem(m,3).start();
            long startTime = System.currentTimeMillis();    //获取开始时间
            new Problem(m,3).solution(m);
//            new Problem(m,3).start();
            long endTime = System.currentTimeMillis();    //获取结束时间

            System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间

        }
    }
}
