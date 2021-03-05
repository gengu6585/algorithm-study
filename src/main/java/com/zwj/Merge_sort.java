package com.zwj;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author:zengwenjie
 * @Date:2021/3/3 20:27
 */
public class Merge_sort {
    public static void main(String[] args) {
        int[] nums = {-1,1,9,5,2,4,7,9,4894,58,48,15,47,18,494,9484,100};
        System.out.println(nums.length);

        System.out.println(Arrays.toString(new Merge_sort().solution(nums, 0, nums.length - 1)));

    }

    public int[] solution(int[] array, int start, int end) {
        if (start == end) {
            return new int[]{array[start]};
        }
        int mid = (start + end) / 2;
        int[] left = solution(array, start, mid);
        int[] right = solution(array, mid + 1, end);
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                k++;
                i++;
            } else {
                result[k] = right[j];
                j++;
                k++;
            }
        }

        for (; i < left.length; i++) {
            result[k] = left[i];
            k++;

        }
        for (; j < right.length; j++) {
            result[k] = right[j];
            k++;


        }



        return result;

    }
}
