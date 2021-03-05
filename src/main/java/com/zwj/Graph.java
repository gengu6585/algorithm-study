package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/5 19:51
 */
public class Graph {
    static GraphNode[] create(int[][] nums) {
        GraphNode[] graphNodes = new GraphNode[nums.length];
        for (int i = 0; i < graphNodes.length; i++) {
            graphNodes[i] = new GraphNode(i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int num : nums[i]) {
                graphNodes[i].neighbors.add(graphNodes[num]);
            }
        }
        return graphNodes;
    }

    public static void main(String[] args) {
        int[][] nums = {{2, 4}, {2}, {3}, {4}, {3}};
        Graph.create(nums);
    }
}
