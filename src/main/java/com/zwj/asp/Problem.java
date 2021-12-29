package com.zwj.asp;

import java.util.*;

/**
 * @Author:zengwenjie
 * @Date:2021-12-24 13:05
 */
public class Problem extends  Thread {
    long startTime = 0;
    static int solutionNums = 0;
    int runningPatter;
    int []baseLine;
    int []row1;
    int []row2;
    int [][] limitOfRow1;
    int [][] limitOfRow2;
    int r;
    int m;
    boolean flag;
    static Object object = new Object();
    HashSet<Integer> subSet1;
    HashSet<Integer> subSet1Row2;
    HashSet<Integer> subSet2;
    HashSet<Integer> currentSet;
    HashSet<Integer> currentSetRow2;
    ArrayDeque<Integer> lastAddIndexStack = null;
    ArrayDeque<Integer> lastAddIndexStackRow2 = null;
    ArrayDeque<Integer> lastAddItemOfSubSet1 = null;
    ArrayDeque<Integer> lastAddItemOfSubSetRow2 = null;
    ArrayDeque<Integer> lastAddItemOfSubSet2 = null;


    public Problem(int m,int runningPatter,long startTime) {
        this.runningPatter = runningPatter;
        init(m);
        this.startTime = startTime;

    }

    void init(int m) {
        subSet1 = new HashSet<Integer>();
        subSet1Row2 = new HashSet<Integer>();
        subSet2=new HashSet<Integer>();
        currentSet=new HashSet<Integer>();
        currentSetRow2=new HashSet<Integer>();
        lastAddIndexStack = new ArrayDeque<>();
        lastAddIndexStackRow2 = new ArrayDeque<>();
        lastAddItemOfSubSet1 = new ArrayDeque<>();
        lastAddItemOfSubSetRow2 = new ArrayDeque<>();
        lastAddItemOfSubSet2 = new ArrayDeque<>();
        this.m=m;
        baseLine = new int[m];
        r=(m-1)/2;

        for (int i = 0; i < m; i++) {
            baseLine[i]=-r+i;
        }
        row1 = baseLine.clone();
        row2 = new int[m];
        //flag初始化为false表示为找到三行序列
        flag = false;
        //初始化limit数组
        limitOfRow1 = new int[m][2];
        limitOfRow2 = new int[m][2];

    }
    public void fintRow2ByFormula(int m){
        int r=(m-1)/2;
        //按照公式从左往右生成第二行
        int[] row2_1 = new int[m];
        row2_1[0] = row1[0];
        for (int i = 0; i < r; i++) {
            row2_1[2*i+1] = row1[r + 1+i];
            row2_1[2*i + 2] = row1[1 + i];
        }
        //按照公式从右往左生成第二行
        int[] row2_2 = new int[m];
        row2_2[m-1] = row1[m-1];
        for (int i = 0; i < r; i++) {
            row2_2[m-2*i-2] = row1[r -1-i];
            row2_2[m-2*i - 3] = row1[m-2 - i];
        }
        row2 = row2_1;
        row1 = baseLine.clone();
        generateLimit(2);
        findRow3(m);
        row1 = baseLine.clone();
        row2 = row2_2;
        generateLimit(2);
        findRow3(m);
    }



    public  void findRow3(int m) {
        int[] queen = new int[m];
        Arrays.fill(queen, 0);
        int row=0;
        for (int i = 0; i < m; i++) {
            queen[i] = limitOfRow2[i][0];
        }
        subSet1.clear();
        subSet2.clear();
        currentSet.clear();
        lastAddIndexStack.clear();
        lastAddItemOfSubSet1.clear();
        lastAddItemOfSubSet2.clear();
        int counter = 0;
        while (row>=0) {
            if (solutionNums >= 5) {
                System.out.println("查找结束");
                return;
            }
            counter++;
            if (counter > 500000000) {
                System.out.println("当前queen为："+ Arrays.toString(queen));
                System.out.println("limit数组为"+ Arrays.deepToString(limitOfRow2));
                counter = 0;
                double percent = 0;
                long mul = 1;
                for (int i = 0; i < 11; i++) {
                    mul *= (limitOfRow2[i][1] - limitOfRow2[i][0] + 1);
                    percent+=(double) (queen[i]-limitOfRow2[i][0])/mul;
                }
                System.out.println("当前搜索进度----" + String.format("%.4f",percent*100) + "%");
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
                        row3[i] = baseLine[queen[i]];
                    }
                    System.out.println("当m=" +m+"时，runningPattern:"+runningPatter+
                            ",找到一组解：");
                    System.out.println("row1: "+ Arrays.toString(row1));
                    System.out.println("row2: "+ Arrays.toString(row2));
                    System.out.println("row3: " + Arrays.toString(row3));

                }
                if (row > 0) {
                    subSet1.remove(lastAddItemOfSubSet1.pop());
                    subSet2.remove(lastAddItemOfSubSet2.pop());
                    currentSet.remove(lastAddIndexStack.pop());
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
        for (int i = 0; i < m; i++) {
            queen[i] = limitOfRow1[i][0];
        }
        lastAddIndexStackRow2.clear();
        lastAddItemOfSubSetRow2.clear();
        subSet1Row2.clear();
        currentSetRow2.clear();

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
                        row2[i] = baseLine[queen[i]];
                    }
                    System.out.println("第一行为："+ Arrays.toString(row1));
                    System.out.println("找到第二行为： "+ Arrays.toString(row2));
                    generateLimit(2);
                    findRow3(m);
                    row1 = baseLine.clone();

                }
                if (row > 0) {
                    subSet1Row2.remove(lastAddItemOfSubSetRow2.pop());
                    currentSetRow2.remove(lastAddIndexStackRow2.pop());
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
//        HashSet<Integer> set1 = new HashSet<>();
//        HashSet<Integer> set2 = new HashSet<>();
        if (currentSet.contains(queen[row])) {
            return false;
        }
        if (subSet1.contains(row1[row] - baseLine[queen[row]])||subSet2.contains(row2[row] - baseLine[queen[row]])) {
            return false;
        }
        currentSet.add(queen[row]);
        subSet1.add(row1[row] - baseLine[queen[row]]);
        subSet2.add(row2[row] - baseLine[queen[row]]);
        lastAddIndexStack.push(queen[row]);
        lastAddItemOfSubSet1.push(row1[row] - baseLine[queen[row]]);
        lastAddItemOfSubSet2.push(row2[row] - baseLine[queen[row]]);
        return true;
    }
    public boolean judgeRow2(int []queen, int row) {
        if (currentSetRow2.contains(queen[row])) {
            return false;
        }
        if (subSet1Row2.contains(row1[row] - baseLine[queen[row]])) {
            return false;
        }
        currentSetRow2.add(queen[row]);
        subSet1Row2.add(row1[row] - baseLine[queen[row]]);
        lastAddIndexStackRow2.push(queen[row]);
        lastAddItemOfSubSetRow2.push(row1[row] - baseLine[queen[row]]);
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
//            sortByLimitLength(limitOfRow1);
        } else if (row == 2) {
            for (int i = 0; i < limitOfRow2.length; i++) {
                limitOfRow2[i][0] = Math.max(Math.max(row1[i] - r, -r), Math.max(row2[i] - r, -r))+r;
                limitOfRow2[i][1] = Math.min(Math.min(row1[i] + r, r), Math.min(row2[i] + r, r))+r;
            }
//            sortByLimitLength(limitOfRow2);
        }

        //按照limit中的区间排序


    }
    class SortObject{
        int row1;
        int row2;
        int [] limitItem;
        int limitSub;

        public SortObject(int row1, int row2, int []limitItem,int limitSub) {
            this.row1 = row1;
            this.row2 = row2;
            this.limitItem = limitItem;
            this.limitSub=limitSub;
        }
    }

    void sortByLimitLength(int [][] limit) {
        ArrayList<SortObject> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new SortObject(row1[i], row2[i], limit[i], limit[i][1] - limit[i][0]));
        }
        list.sort((a,b)->b.limitSub-a.limitSub);
        for (int i = 0; i < m; i++) {
            row1[i] = list.get(i).row1;
            row2[i] = list.get(i).row2;
            limit[i] = list.get(i).limitItem;
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
//            new Problem(m,1).solution(m);
//            new Problem(m,3).start();
            long startTime = System.currentTimeMillis();    //获取开始时间
            new Problem(m,3,startTime).solution(m);
//            new Problem(m,3).start();
            long endTime = System.currentTimeMillis();    //获取结束时间

            System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间

        }
    }
}
