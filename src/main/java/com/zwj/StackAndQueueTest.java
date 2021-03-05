package com.zwj;

import java.util.*;

/**
 * @Author:zengwenjie
 * @Date:2021/3/1 12:40
 */
public class StackAndQueueTest {
    public static void main(String[] args) {
//        Deque<Integer> stack = new ArrayDeque<Integer>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        stack.add(9);
//        stack.add(8);
//        stack.push(7);
//        stack.addLast(8);
//        System.out.println(priorityQueue.toString());
//
//        System.out.println(stack);
//        System.out.println(stack.peek());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        priorityQueue.add(5);
        priorityQueue.add(7);
        priorityQueue.add(9);
        priorityQueue.add(1);
        priorityQueue.add(6);
        priorityQueue.add(12);
        priorityQueue.add(4);
        System.out.println(priorityQueue.toString());
        for (int i = 0; i < 6; i++) {
            priorityQueue.remove();
            System.out.println(priorityQueue.toString());
        }
        MyDeque mydeque = new MyDeque();
        HashSet<MyDeque> hashSet = new HashSet<>();
        mydeque.add(1);
        mydeque.add(2);
        mydeque.add(3);
        mydeque.add(4);
        MyDeque clone = ((MyDeque) mydeque.clone());

        System.out.println(clone.equals(mydeque));
        hashSet.add(mydeque);
        hashSet.add(clone);
        System.out.println(hashSet);
        HashSet<String> strings = new HashSet<>();
        strings.add("1");
        strings.add("1");
        System.out.println(strings);

        System.out.println("----------");
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(1);
        deque.add(1);
        deque.add(1);




    }
}
