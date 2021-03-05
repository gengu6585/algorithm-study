package com.zwj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:zengwenjie
 * @Date:2021/3/1 20:44
 */
public class ArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        ArrayList<ShootSection> shootSections = new ArrayList<>();
        for (int[] point : points) {
            shootSections.add(new ShootSection(point[0], point[1]));
        }
        System.out.println("气球区段为：-----"+ Arrays.deepToString(points));
        int result = new ArrowsToBurstBalloons().solution(shootSections);
        System.out.println("共需要----"+result+"支箭");

    }
    public static class ShootSection{
        int left;
        int right;

        public ShootSection(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "[" +
                     + left +
                    ", " + right +
                    ']';
        }
    }

    int solution(ArrayList<ShootSection> balloonsList) {
        balloonsList.sort(new Comparator<ShootSection>() {
            @Override
            public int compare(ShootSection o1, ShootSection o2) {
                return Integer.compare(o1.right ,o2.right);
            }
        });
        System.out.println("对区段进行按右端点排序----" + balloonsList.toString());
        int shootNums = 1;
        if (balloonsList.isEmpty()) {
            return 0;
        }
        int right = balloonsList.iterator().next().right;
        for (ShootSection shootSection : balloonsList) {
            if (shootSection.left > right) {
                shootNums++;
                right = shootSection.right;
            }
        }

        return shootNums;
    }
}
