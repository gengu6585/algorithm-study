package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/28 9:42
 */
public class MyPriorityQueue implements Heap {
    private int[] data;
    private int length;

    public MyPriorityQueue(int[] data) {
        if (data == null) {
            return;
        }
        this.length=data.length;
        this.data = data;
    }

    @Override

    public void buildHeap() {
        int pos = (this.length - 1) / 2;
        for (int i = pos; i >= 0; i--) {
            sink(pos);
        }
    }

    @Override
    public void sink(int pos) {
        int left = leftTree(pos);
        int right = rightTree(pos);
        if (left == -1) {
            return;
        }
        if (right == -1) {
            if (data[pos] > data[left]) {
                swap(pos,left);
            }
        }
        if (data[left] < data[right]) {
            if (data[pos] > data[left]) {
                swap(pos, left);
                sink(left);
            } else {
                swap(pos, right);
                sink(right);
            }
        } else {
            if (data[pos] > data[right]) {
                swap(pos, right);
                sink(right);
            } else {
                swap(pos, left);
                sink(left);
            }

        }


    }

    @Override
    public void add(int k) {
        if (data.length == length) {
            int[] newData = new int[length * 2 + 1];
            System.arraycopy(data, 0, newData, 0, length);
            data = newData;
        }
        data[length - 1] = k;
        int pos = length - 1;
        while (pos != 0) {
            if (pos % 2 == 0) {
                if (data[pos] < data[(pos - 2) / 2]) {
                    sink((pos - 2) / 2);
                    pos = (pos - 2) / 2;
                }

            } else {
                if (data[pos] < data[(pos - 1) / 2]) {
                    sink((pos - 1) / 2);
                    pos = (pos - 1) / 2;
                }
            }
        }
    }

    @Override
    public int pop() {
        swap(0, length - 1);
        length--;
        return data[length];
    }

    @Override
    public int[] sort() {
        if (length == 0) {
            return null;
        }
        int[] result = new int[length];
        int pos = length - 1;
        while (length != 0) {
            result[pos] = pop();
            pos--;
        }
        return result;
    }


    public void swap(int left, int right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }

    private int leftTree(int pos) {
        if (2 * pos + 1 >= this.length) {
            return -1;
        }
        return 2 * pos + 1;
    }
    private int rightTree(int pos) {
        if (2 * pos + 2 >= this.length) {
            return -1;
        }
        return 2 * pos + 2;
    }
}
