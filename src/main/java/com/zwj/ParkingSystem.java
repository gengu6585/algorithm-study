package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/19 22:05
 */
public class ParkingSystem {
    int big;
    int medium;
    int small;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (this.big > 0) {
                    big--;
                    return true;
                }

                break;
            case 2:
                if (this.medium > 0) {
                    medium--;
                    return true;
                }

            break;
            case 3:
                if (this.small > 0) {
                    small--;
                    return true;
                }

            break;
        }
        return false;
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));

    }
}
