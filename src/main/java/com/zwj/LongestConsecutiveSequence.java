package com.zwj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author:zengwenjie
 * @Date:2021/3/29 11:18
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int []nums ={0,3,7,2,5,8,4,6,0,1};
        int result = new LongestConsecutiveSequence().solution(nums);
        System.out.println(result);
    }
    int solution(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        nums = Arrays.stream(set.toArray()).mapToInt((o) -> (Integer) o).toArray();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] parent = new int[nums.length];
        int[] rank = new int[nums.length];
        int[] size = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            parent[i] = i;
        }
        Arrays.fill(size, 1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - 1)) {
                union(i, (Integer) map.get(nums[i]- 1), parent, rank,size);
            }
            if (map.containsKey(nums[i] + 1)) {
                union(i, (Integer) map.get(nums[i]+ 1), parent, rank,size);
            }
        }

        int maxSize = 0;
        for (int i = 0; i < map.size(); i++) {
            if (size[i] > maxSize) {
                maxSize = size[i];
            }
        }
        return maxSize;
    }

    boolean union(int x, int y,int []parent,int []rank,int []size) {
        if (connected(x, y, parent)) {
            return false;
        }
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);
        int x_size = size[x_parent];
        int y_size = size[y_parent];
        if (x_parent != y_parent) {
            if (rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
                size[x_parent] = x_size + y_size;
                return true;
            } else if (rank[x_parent] < rank[y_parent]) {
                parent[x_parent] = y_parent;
                size[y_parent] = x_size + y_size;
                return true;
            } else {
                parent[y_parent] = x_parent;
                size[x_parent] = x_size + y_size;
                rank[x_parent]++;
                return true;
            }
        }
        return true;
    }

    boolean connected(int x, int y,int []parent) {
        return find(x,parent) == find(y,parent);
    }

    int find(int x,int []parent) {
        int result = x;
        while (result != parent[result]) {
            result = parent[result];
        }
        return result;
    }
}
