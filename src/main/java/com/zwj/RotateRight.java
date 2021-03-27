package com.zwj;

/***
 * description: 旋转链表
 * @param: LeetCodeLink:https://leetcode-cn.com/problems/rotate-list/
 * @return:
 * @author zwj
 * @date: 2021/3/27 22:44
 */
public class RotateRight {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    ListNode solution(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode _head = head;
        int length = 1;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        if (k%length == 0) {
            return _head;
        }
        ListNode last = head;
        head = _head;
        for (int i = 0; i < length - k % length-1; i++) {
            head = head.next;
        }
        ListNode result = head.next;
        head.next = null;
        last.next = _head;
        return result;
    }
}
