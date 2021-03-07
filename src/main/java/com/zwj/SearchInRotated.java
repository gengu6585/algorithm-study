package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/6 15:53
 */
public class SearchInRotated {
    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {5,1,2,3};
        int[] nums = {2,3,4,5,6,7,8,9,1};
//        int[] nums = {2,3,5,1};
//        int[] nums = {5,1,3};
//        int[] nums = {7, 8, 1, 2, 3, 4, 5, 6};
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {0,1,2,4,5,6,7};
//        int []nums = {3,1};

        int result = new SearchInRotated().solution(nums, 9);
        System.out.println(result);
    }

    int solution(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid =0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (start == end) {
                if (nums[start] != target) {
                    return -1;
                } else return start;
            }
            if (start + 1 == end) {
                if (nums[end] != target) {
                    return -1;
                } else return end;
            }
//            左侧是正常的，右侧是旋转的
            if (nums[start] < nums[mid]) {
                if (target < nums[mid]) {
//                    找到左侧
                    int result = binarySearch(nums, target, start, mid - 1);
                    if (result != -1) {
                        return result;
                    }
//                    没有找到
                    start = mid + 1;
                    continue;
                }
                start = mid + 1;
            }
//            右侧是正常的
            else {
                if (target > nums[mid]) {
                    int result = binarySearch(nums, target, mid + 1, end);
                    if (result != -1) {
                        return result;
                    }
                    end = mid - 1;
                    continue;
                }
                end = mid - 1;

            }
        }

        return 0;
    }

    int binarySearch(int[] nums,int target,int start,int end) {
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
