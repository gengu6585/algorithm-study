package com.zwj;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

/**
 * @Author:zengwenjie
 * @Date:2021/3/13 23:43
 */
public class MyHashSet {
    private final int DEFAULT_LENGTH = 17;
    private int length;
    private int elementNums = 0;
    private int[] datas = null;
    public MyHashSet() {
        this.datas = new int[DEFAULT_LENGTH];
        length = DEFAULT_LENGTH;

        Arrays.fill(datas, Integer.MIN_VALUE);
    }

    public void add(int key) {
        if (_contains(key) != -1) {
            return;
        }
        if (elementNums == length) {
            dataCopy();
        }
        int pos = new Integer(key).hashCode() % this.length;
        while (datas[pos] != Integer.MAX_VALUE && datas[pos] != Integer.MIN_VALUE) {
            pos = posAdd(pos);
        }
        datas[pos] = key;
        elementNums++;
    }

    public void remove(int key) {
        int pos = _contains(key);
        if (pos == -1) {
            return;
        } else {
            this.datas[pos] = Integer.MAX_VALUE;
            elementNums--;
        }

    }

    private int _contains(int key) {
        int pos = new Integer(key).hashCode() % this.length;
        if (datas[pos] == Integer.MIN_VALUE) {
            return -1;
        }
        int count = 0;
        while (datas[pos] != key && datas[pos] != Integer.MIN_VALUE) {
            pos = posAdd(pos);
            count++;
            if (count == length) {
                return -1;
            }
        }
        if (datas[pos] == key) {
            return pos;
        } else {
            return -1;
        }
    }

    boolean contains(int key) {
        int pos = this._contains(key);
        if ((pos) != -1) {
            return true;
        } else return false;
    }


    int  posAdd(int pos) {
        if (pos + 1 == this.length) {
            return 0;
        }
        return ++pos;
    }
    void dataCopy() {
        this.length = 2 * length - 1;
        int[] olddata = datas;
        datas = new int[length];
        Arrays.fill(datas, Integer.MIN_VALUE);
        elementNums = 0;
        for (int i = 0; i < olddata.length; i++) {
            if (olddata[i] != Integer.MIN_VALUE&&olddata[i] != Integer.MAX_VALUE) {
                this.add(olddata[i]);
            }
        }
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        for (int i = 0; i < 100000; i++) {
            hashSet.add((int) Math.floor(Math.random()*10000));
        }
        boolean result = hashSet.contains(3);
        System.out.println(result);

        System.out.println(hashSet);
        System.out.println(hashSet.elementNums);
        System.out.println(hashSet.datas.length);
    }

    @Override
    public String toString() {
        return "MyHashSet{" +
                "datas=" + Arrays.toString(datas) +
                '}';
    }
}
