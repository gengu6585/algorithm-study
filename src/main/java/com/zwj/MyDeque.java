package com.zwj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zengwenjie
 * @Date:2021/3/2 17:04
 */
public class MyDeque extends ArrayList<Integer> {
    @Override
    public int hashCode() {
        int sum=0;
        for (Integer integer : this) {
            sum += new Integer(integer).hashCode();
        }
        return new Integer(sum).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        ArrayList<Integer> obj1 = (ArrayList<Integer>) obj;
        if (((ArrayList<Integer>) obj).size() == 0 && ((ArrayList<Integer>) this).size()==0) {
            return true;
        }
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (Integer integer : obj1) {
            if (!map1.containsKey(integer)) {
                map1.put(integer,1);
            } else map1.replace(integer,map1.get(integer)+1);
        }
        for (Integer integer : this) {
            if (!map2.containsKey(integer)) {
                map2.put(integer,1);
            } else map2.replace(integer,map2.get(integer)+1);
        }
        boolean flag = true;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map1.entrySet()) {
            if (map2.get(integerIntegerEntry.getKey())==null||!map2.get(integerIntegerEntry.getKey()).equals(integerIntegerEntry.getValue())) {
                flag = false;
            }
        }

        return flag;
    }

    int getSum() {
        int sum = 0;
        for (Integer integer : this) {
            sum += integer;
        }
        return sum;
    }

    public static void main(String[] args) {
        MyDeque myDeque = new MyDeque();
        myDeque.add(1);
        myDeque.add(2);
        ArrayList<Integer> clone = (ArrayList<Integer>) myDeque.clone();
        System.out.println(myDeque.equals(clone));
    }
}
