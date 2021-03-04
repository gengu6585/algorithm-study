package com.zwj;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author:zengwenjie
 * @Date:2021/3/4 12:08
 */
public class CountSmaller {
    public static void main(String[] args) {
        int[] nums = {7,5, 2, 6, 1};
        ArrayList<Integer> count = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            count.add(0);
        }
        Pair<Integer, Integer>[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair<>(nums[i], i);
        }
        new CountSmaller().solution(pairs, 0, pairs.length - 1, count);
        System.out.println(count.toString());
    }
    Pair<Integer, Integer>[] solution(Pair<Integer, Integer>[] pairs,int start,int end,ArrayList<Integer>count) {
        if (end == start) {
            return new Pair[]{pairs[start]};
        }
        int mid = (end + start) / 2;
        Pair<Integer, Integer>[] left = solution(pairs, start, mid,count);
        Pair<Integer, Integer>[] right = solution(pairs, mid + 1, end,count);
        Pair<Integer, Integer>[] result = new Pair[end - start + 1];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            boolean flag = true;
            if (left[i].getKey() <= right[j].getKey()) {
                result[k] = left[i];
                count.set(left[i].getValue(), count.get(left[i].getValue()) + j + 1);
                k++;
                i++;
                flag = false;
            }
            else   {
                result[k] = right[j];
                k++;
                j++;
                flag = true;

            }

        }
        for (; i < left.length; i++) {
            result[k] = left[i];
            count.set(left[i].getValue(), count.get(left[i].getValue()) + j);
            k++;
        }
        for (; j < right.length; j++) {
            result[k] = right[j];
            k++;
        }
        return result;
    }
}
