package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/6 13:38
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 3;
        int result = new BinarySearch().solution1(nums, target);
        System.out.println(result);
    }
    int solution1(int[] nums, int target) {

        return binarySeach(nums, target, 0, nums.length - 1);
    }

    int binarySeach(int[] nums, int target, int start, int end) {
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] > target) {
            if (start + 1 == end) {
                return binarySeach(nums, target, end, end);
            }
            return binarySeach(nums, target, start, mid - 1);
        } else {
            if (start + 1 == end) {
                return -1;
            }
            return binarySeach(nums, target, mid + 1, end);
        }



    }

    int solution2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}
