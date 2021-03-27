package com.zwj;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author:zengwenjie
 * @Date:2021/3/23 23:16
 */
public class CanMakeArithmeticProgression {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        boolean result = new CanMakeArithmeticProgression().solution(arr);
        System.out.println(result);
    }
    boolean solution(int[] arr) {
        if (arr == null) {
            return false;
        }
        if (arr.length <= 2) {
            return true;
        }
        Arrays.sort(arr);
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] - arr[i - 2] != arr[i] - arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
