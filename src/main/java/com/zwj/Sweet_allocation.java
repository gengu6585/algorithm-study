package com.zwj;
import java.util.*;
/**
 * @Author:zengwenjie
 * @Date:2021/2/28 16:32
 */
public class Sweet_allocation {
    public static void main(String[] args) {
        List<Integer> sweet = Arrays.asList(20,8,3,1,6);
        List<Integer> need = Arrays.asList(15,5,9,2,10,9);
        long start = System.currentTimeMillis();
        System.out.println("糖果大小分别为"+"-----"+sweet);
        System.out.println("需求因子分别为"+"-----"+need);
        int num = new Sweet_allocation().sweet_allocation(sweet, need);
        System.out.println("最后能满足的个数"+"-----"+num);
        long last = System.currentTimeMillis();
        System.out.println("程序执行时间为"+(last-start)+"ms");
    }
    public int sweet_allocation(List<Integer> sweet, List<Integer> need) {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int) o1 - (int) o2;
            }
        };
        sweet.sort(comparator);
        need.sort(comparator);
        int s_size = sweet.size();
        int n_size = need.size();
        int s = 0,n =0;
        while (s < s_size && n < n_size) {
            if (((int) need.get(n)) <= ((int) sweet.get(s))) {
                n++;
            }
                s++;
        }
        return n;
    }
}