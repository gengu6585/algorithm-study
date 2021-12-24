package com.zwj;

import java.util.Arrays;
import java.util.HashSet;

/***
 * description: 并查集实现
 * @param:
 * @return:
 * @author zwj
 * @date: 2021/3/29 11:18
 */
public class DisjointSet {
    int solution(int[][] nums) {
        int[] parent = new int[nums.length];
        int[] rank = new int[nums.length];
        Arrays.fill(rank, 0);
        Arrays.fill(parent, -1);
        HashSet<Integer> friendsCircle = new HashSet<>();

        return 1;
    }

    boolean union(int x, int y,int []parent,int []rank) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);
        if (x_parent != y_parent) {
            if (rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            } else if (rank[x_parent] < rank[y_parent]) {
                parent[x_parent] = y_parent;
            } else {
                parent[y_parent] = x_parent;
                rank[y_parent]++;
            }
        }
        return true;
    }

    boolean connected(int x, int y,int []parent) {
        return find(x,parent) == find(y,parent);
    }

    int find(int x,int []parent) {
        int result = x;
        while (result != -1) {
            result = parent[x];
        }
        return result;
    }

}
