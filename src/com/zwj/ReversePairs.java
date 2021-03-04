package com.zwj;

import java.util.Arrays;

/**
 * @Author:zengwenjie
 * @Date:2021/3/4 10:00
 */
public class ReversePairs {
    int reverseParisNums = 0;
    public static void main(String[] args) {
        int nums[] = {5,4,3, 2, 1};
        Integer reversePaisNums = new Integer(0);
        ReversePairs reversePairs = new ReversePairs();

        int result[] = reversePairs.solution(nums, 0, nums.length - 1);
        System.out.println("原数组----------"+Arrays.toString(nums));
        System.out.println("归并排序后的数组--------"+Arrays.toString(result));
        System.out.println("逆序对个数---------"+reversePairs.reverseParisNums);
    }



    public int[] solution(int[] nums, int start, int end) {
        if (start == end) {
            return new int[]{nums[start]};
        }
        int mid = (end + start) / 2;
        int  left[] = solution(nums, start, mid);
        int right[] = solution(nums, mid + 1, end);
        int[] result = new int[end - start + 1];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                k++;
                i++;
            }
            else   {
                result[k] = right[j];
                k++;
                j++;
                reverseParisNums += left.length - i;
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
