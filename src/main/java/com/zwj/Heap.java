package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/28 9:34
 */
public interface Heap {

    void buildHeap();

    void sink(int pos);

    void add(int k);

    int pop();

    int[] sort();

    void swap(int left,int right);
}
