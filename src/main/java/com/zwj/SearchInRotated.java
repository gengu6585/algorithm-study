package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/6 15:53
 */
public class SearchInRotated {
    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {5,1,2,3};
//        int[] nums = {2,3,5,1};
//        int[] nums = {5,1,3};
//        int[] nums = {7, 8, 1, 2, 3, 4, 5, 6};
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {0,1,2,4,5,6,7};
//        int []nums = {3,1};

        int result = new SearchInRotated().solution(nums, 1);
        System.out.println(result);
    }

    int solution(int[] nums, int target) {

        int left = findLeft(nums);
        int right = findRight(nums);
        System.out.println();
//        if (left == 0) {
//            int _left = binarySearch(nums, target, 0, 0);
//            int _right = binarySearch(nums, target, 1, nums.length - 1);
//            return _left==-1?_right:_left;
//        }
        if (right != nums.length-1) {
            int _left = binarySearch(nums, target, 0, right-1);
            int _right = binarySearch(nums, target, right, nums.length - 1);
            return _left==-1?_right:_left;
        }
        if (left != 0) {
            int _left = binarySearch(nums, target, 0, left);
            int _right = binarySearch(nums, target, left+1, nums.length - 1);
            return _left==-1?_right:_left;
        }
        return binarySearch(nums, target, 0, nums.length - 1);
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

    int findRight(int []nums) {
        int start = 0;
        int end = nums.length - 1;
        int base = (start + end) / 2;
        start = base + 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[base]) {
                end = mid - 1;
                continue;
            }
            start = mid + 1;

        }

        return end;
    }
    int findLeft(int []nums) {
        int start = 0;
        int end = nums.length - 1;
        int base = (start + end) / 2;
        end = base - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[base]) {
                start = mid + 1;
                continue;
            }

            end = mid - 1;

        }
        return start;
    }
}
