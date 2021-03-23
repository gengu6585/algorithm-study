package com.zwj;

import java.util.List;

/***
 * description: 分割链表
 * @param: LeetCodeLink:https://leetcode-cn.com/problems/partition-list-lcci/
 * @author zwj
 * @date: 2021/3/22 10:56
 */
public class PartitionListLcci {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

     ListNode listBuild(int[] nums) {
        if (nums == null) {
            return null;
        }
        ListNode head = new ListNode(-1);
         ListNode _head = head;
        for (int i = 0; i < nums.length; i++) {
            head.next = new ListNode(nums[i]);
            head = head.next;
        }
        return _head.next;
    }

    public static void main(String[] args) {
        PartitionListLcci partitionListLcci = new PartitionListLcci();
        int[] nums = {3, 5, 8, 5, 10, 2, 1};
        int x = 5;
        ListNode head = partitionListLcci.listBuild(nums);
        ListNode result = partitionListLcci.solution(head, 5);
        System.out.println(result);
    }


    ListNode solution(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode _head = new ListNode(-1);
        ListNode node = _head;
        while (head != null) {
            if (head.val >= x) {
                //头插
                ListNode headNext = head.next;
                ListNode nodeNext = node.next;
                node.next = head;
                head.next = nodeNext;
                head = headNext;
            } else {
                //尾插
                ListNode nodeNext = node.next;
                ListNode headNext = head.next;
                node.next = head;
                head.next = nodeNext;
                head = headNext;

                node = node.next;
            }
            }
        ListNode nodeNext = node.next;
        node.next = new ListNode(x);
        node.next.next = nodeNext;

        return _head.next;
    }
}
