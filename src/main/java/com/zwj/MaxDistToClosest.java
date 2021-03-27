package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/23 23:45
 */
public class MaxDistToClosest {


    int solution(int[] seats) {
        if (seats == null) {
            return -1;
        }
        int minDistance = 0;
        int count = 0;
        int pos = 0;
        while (pos < seats.length && seats[pos] != 1) {
            pos++;
            minDistance++;
        }
        for (int i = pos; i < seats.length; i++) {
            if (seats[i] == 1) {
                if ((count + 1) / 2 > minDistance) {
                    minDistance = (count + 1) / 2;
                }
                count = 0;
            } else {
                count++;
                if (i == seats.length - 1) {
                    if (minDistance < count) {
                        minDistance = count;
                    }
                }

            }
        }
        return minDistance;
    }
}
