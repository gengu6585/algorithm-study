package com.zwj;

import java.util.PriorityQueue;

/**
 * @Author:zengwenjie
 * @Date:2021/3/2 11:11
 */
public class MinRefuelStops {
    public static void main(String[] args) {
        int target = 100;
        int startFuel = 1;
        int[][] stations = {};

        int result = new MinRefuelStops().solution(target, startFuel, stations);
        System.out.println(result);
    }

    int solution(int target, int startFuel, int[][] stations) {
        int pos = 0;
        int currentFuel = startFuel;
        int addOiltimes = 0;
        if (stations.length==0) {
            if (target > startFuel) {
                return -1;
            } else return 0;
            }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 0; i < stations.length; i++) {
            if (pos + currentFuel >= stations[i][0]) {
                currentFuel -= stations[i][0] - pos;
                pos = stations[i][0];
                heap.add(stations[i][1]);
                continue;
            }
            if (heap.isEmpty()) {
                return -1;
            }
            while (pos + currentFuel < stations[i][0]&&!heap.isEmpty()) {
                currentFuel += heap.poll();
                addOiltimes++;
            }
            if (currentFuel + pos < stations[i][0]) {
                return -1;
            }
            heap.add(stations[i][1]);
            currentFuel -= stations[i][0] - pos;
            pos = stations[i][0];
        }
        //最后一次对目标点进行判断
        if (pos + currentFuel >= target) {
            return addOiltimes;
        }
        while (pos + currentFuel < target&&!heap.isEmpty()) {
            currentFuel += heap.poll();
            addOiltimes++;
        }
        if (currentFuel + pos < target) {
            return -1;
        }
        return addOiltimes;
    }
}
