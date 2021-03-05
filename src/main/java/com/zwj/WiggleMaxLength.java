package com.zwj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @Author:zengwenjie
 * @Date:2021/2/28 18:53
 */
public class WiggleMaxLength {
    static final int STATIC = 0;
    static final int UP = 1;
    static final int DOWN = 2;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] array = {1,17,5,10,13,15,10,5,16,8};
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("输入的序列为："+"-----"+ Arrays.toString(array));
        int result = new WiggleMaxLength().solution(array,list);
        System.out.println("最长摆动子序列长度为" +list.size());
        System.out.println("最长摆动子序列为："+"-----"+list.toString());
        long end = System.currentTimeMillis();
        System.out.println("程序运行时间" +
                "-----"+(start-end)+"ms");


    }

    public int solution(int [] array, List<Integer> list) {
        //开始状态设置设为 不变
        int state = STATIC;
        int maxLength = 1;
        list.add(array[0]);
//      从第二位元素开始遍历，比较与前一个元素的大小修改状态
        for (int i = 1; i < array.length; i++) {
            switch (state) {
                case STATIC:
                    if (array[i - 1] < array[i]) {
                        state = UP;
                        maxLength++;
                        list.add(array[i]);
                    } else if (array[i - 1] > array[i]) {
                        state = DOWN;
                        maxLength++;
                        list.add(array[i]);
                    }
                    break;

                case UP:
                    if (array[i - 1] < array[i]) {
                        //如果一直增加，则移除上次加入list的数，再加入当前这个更大的数，
                        //保证最后加入摆动子序列是一直递增得到最大的那个数
                        list.remove(list.size() - 1);
                        list.add(array[i]);
                    } else if (array[i - 1] > array[i]) {
                        state = DOWN;
                        maxLength++;
                        list.add(array[i]);
                    }
                    break;
                case DOWN:
                    if (array[i - 1] < array[i]) {
                        state = UP;
                        maxLength++;
                        list.add(array[i]);
                    } else if (array[i - 1] > array[i]) {
                        //如果一直减少，则移除上次加入list的数，再加入当前这个更小的数，
                        //保证最后加入摆动子序列是一直递减得到最小的那个数
                        list.remove(list.size() - 1);
                        list.add(array[i]);
                    }
                    break;
            }
        }
        return maxLength;
    }
}
