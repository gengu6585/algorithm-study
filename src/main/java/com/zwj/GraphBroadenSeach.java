package com.zwj;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author:zengwenjie
 * @Date:2021/3/6 12:59
 */
public class GraphBroadenSeach {
    void bfs(GraphNode graphNode,int []visited) {
        ArrayDeque<GraphNode> queue = new ArrayDeque<>();
        queue.add(graphNode);
        while (queue.size() != 0) {
            GraphNode node = queue.remove();
            visited[node.label] = 1;
            System.out.println(node.label);
            for (GraphNode neighbor : node.neighbors) {
                if (visited[neighbor.label] == 0) {
                    visited[neighbor.label] = 1;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{2, 4}, {2}, {3}, {4}, {3}};
//        int[][] nums = {{1}, {2},{0}};
        GraphNode[] graph = Graph.create(nums);
        Integer[] integers = Stream.iterate(0, a -> a ).limit(nums.length).toArray(Integer[]::new);
        int[] visited = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        int[] visited1 = visited.clone();
        System.out.println("广度搜索序列");
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                new GraphBroadenSeach().bfs(graph[i], visited);

            }
        }
        System.out.println("深度搜索序列");
        for (int i = 0; i < graph.length; i++) {
            if (visited1[i] == 0) {
                new GraphDeepSearch().dfs(graph[i], visited1);
            }
        }
    }
}
