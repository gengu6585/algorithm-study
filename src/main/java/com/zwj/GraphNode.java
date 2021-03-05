package com.zwj;

import java.util.ArrayList;

/**
 * @Author:zengwenjie
 * @Date:2021/3/5 19:31
 */
public class GraphNode {
    int label;
    ArrayList<GraphNode> neighbors=new ArrayList<>();

    public GraphNode(int label) {
        this.label = label;
    }

    public GraphNode() {
    }

    @Override
    public String toString() {
        return ""+label;
    }
}
