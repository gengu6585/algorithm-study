package com.zwj;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author:zengwenjie
 * @Date:2021/3/5 19:35
 */
public class GraphDeepSearch {
    public static void main(String[] args) {
        int[][] nums = {{2, 4}, {2}, {3}, {4}, {3}};
        GraphNode[] graph = Graph.create(nums);
        Integer[] integers = Stream.iterate(0, a -> a ).limit(nums.length).toArray(Integer[]::new);
        int[] visited = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                new GraphDeepSearch().dfs(graph[i],visited);

            }
        }
    }
    void dfs(GraphNode node, int[] visit) {
        if (node == null) {
            return;
        }
        visit[node.label] = 1;
        System.out.println(node.label);
        for (GraphNode neighbor : node.neighbors) {
            if (visit[neighbor.label] == 0) {
                dfs(neighbor, visit);
            }
        }
        return;
    }

}
