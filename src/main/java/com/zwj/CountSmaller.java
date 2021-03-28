package com.zwj;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

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
        new CountSmaller().solution1(pairs, 0, pairs.length - 1, count);
//        new CountSmaller().solution2(nums, count);
        System.out.println(count.toString());
    }
    Pair<Integer, Integer>[] solution1(Pair<Integer, Integer>[] pairs,int start,int end,ArrayList<Integer>count) {
        if (end == start) {
            return new Pair[]{pairs[start]};
        }
        int mid = (end + start) / 2;
        Pair<Integer, Integer>[] left = solution1(pairs, start, mid,count);
        Pair<Integer, Integer>[] right = solution1(pairs, mid + 1, end,count);
        Pair<Integer, Integer>[] result = new Pair[end - start + 1];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].getKey() <= right[j].getKey()) {
                result[k] = left[i];
                count.set(left[i].getValue(), count.get(left[i].getValue()) + j );
                k++;
                i++;
            }
            else   {
                result[k] = right[j];
                k++;
                j++;

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

    void solution2(int[] nums, List<Integer> result) {
        if (nums == null || nums.length == 0) {
            return;
        }
        TreeNode node = new TreeNode(nums[nums.length - 1]);
        result.set(nums.length - 1, 0) ;
        for (int i = nums.length - 2; i >= 0; i--) {
            binaryTreeInsert(node, nums[i], result,0,i);
        }
    }

    void binaryTreeInsert(TreeNode node, int value, List<Integer> count,int smallerCount,int i) {
        if (value < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(value);
                count.set(i,smallerCount);
                node.count++;
                return;
            }
            node.count++;
            binaryTreeInsert(node.left, value, count,smallerCount,i);
        } else if (value > node.val) {

            smallerCount += node.count+node.repeat+1;
            if (node.right == null) {
                node.right = new TreeNode(value);
                count.set(i,smallerCount);
                return;
            }

            binaryTreeInsert(node.right, value, count, smallerCount,i);
        } else {
            smallerCount += node.count;
            count.set(i,node.count);
            node.repeat++;
        }

    }
}
