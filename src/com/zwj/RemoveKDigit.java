package com.zwj;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author:zengwenjie
 * @Date:2021/2/28 22:53
 */
public class RemoveKDigit {
    public static void main(String[] args) {
//        String nums = "1432219";
        String nums = "1432219";
        int k = 3;
        char[] chars = nums.toCharArray();
        int[] array =new int[nums.length()];
        for (int i = 0; i < chars.length; i++) {
            array[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        System.out.println("需移除的数字字串为-----"+nums+"，移除"+k+"位");
        System.out.println("转化为数组-----"+ Arrays.toString(array));
        String resultString = new RemoveKDigit().solution2(array,k);
        System.out.println("移除" + k +
                "位数字得到最小的数为-----" + resultString);
    }

    String solution1(int[] array,int k) {

        int counts = 0;

        int circleNums = array.length;
        for (int j = 0; j < k; j++) {
            int index = 0;
            for (int i = 1; i < circleNums; i++) {
                if (array[i] == -1) {
                    continue;
                }
                if (array[index] ==array[i]&&i==circleNums-1){
                    index=i;
                    array[index] = -1;
                    circleNums--;
                    break;
                }
                if (array[index] ==array[i]){
                    index=i;
                    continue;
                }

                if (array[index] > array[i]) {
                    array[index] = -1;
                    index = i;
                    break;
                }
                if (array[index] < array[i] && i == circleNums-1) {
                    array[i] = -1;
                    circleNums--;
                    break;
                }
                index = i;
            }
        }
        if(array.length-k==0){
            return "0";
        }
        int[] result = new int[array.length-k];
        int resultIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != -1) {
                result[resultIndex] = array[i];
                resultIndex++;
            }
        }
        boolean firstAppend=true;
        StringBuilder resultString = new StringBuilder("");
        for (int i = 0; i < result.length; i++) {
            if(!firstAppend ||result[i]!=0){
                resultString.append(result[i]);
                firstAppend=false;
            }

        }
        if (resultString.toString().equals("")) {
            resultString.append("0");
        }
        return resultString.toString();
    }
    String solution2(int[] array,int k){
        if (array.length - k == 0) {
            return "0";
        }
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(array[0]);
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < array.length; i++) {
            while (stack.size()!=0 && array[i] < stack.peek()&&k>0) {
                    stack.pop();
                    k--;
            }
            if (stack.size()!=0||array[i]!=0) {
                stack.push(array[i]);
            }

        }
        if (stack.isEmpty()) {
            return "0";
        }
        while (stack.size() != 0 && k > 0) {
            stack.pop();
            k--;
        }
        Iterator<Integer> iterator = stack.descendingIterator();
        while (iterator.hasNext()) {
            result.append(iterator.next());
        }
        return result.toString();
    }

}

