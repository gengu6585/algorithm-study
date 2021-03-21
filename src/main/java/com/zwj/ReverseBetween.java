package com.zwj;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/***
 * description: 反转链表
 * LeetCodeLink：https://leetcode-cn.com/problems/reverse-linked-list-ii/comments/
 * @return:
 * @author zwj
 * @date: 2021/3/20 23:59
 */
public class ReverseBetween {

      static public class ListNode {
          int val;
          ListNode next;
        ListNode() {}
         ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode solution(ListNode node, int left, int right) {
        if (left < 0 || right < 0||node==null) {
            return null;
        }
        if (left == right) {
            return node;
        }
        ListNode head = new ListNode(-1);
        ListNode _head = head;
        head.next = node;
        ListNode leftNode = null;
        ListNode rightNode = null;
        for (int i = 0; i < right&&head!=null; i++) {
            if (i == left - 1) {
                leftNode = head;
            }
            head = head.next;
            if (i == right - 1) {
                rightNode = head;
            }
        }
        if (head == null) {
            return null;
        }
        if (leftNode.next == rightNode) {
            return node;
        }


        ListNode posNode = leftNode.next;
        leftNode.next = null;
        ListNode mark = posNode;
        while (posNode != rightNode) {
            ListNode behind = leftNode.next;
            leftNode.next = posNode;
            ListNode front = posNode.next;
            posNode.next = behind;
            posNode = front;
        }
        ListNode behind = leftNode.next;
        leftNode.next = posNode;
        ListNode front = posNode.next;
        posNode.next = behind;
        posNode = front;

        mark.next= front;

        return _head.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        for (int i = 1; i <10; i++) {
            node.next = new ListNode(i+1);
            node = node.next;
        }
        ListNode solution = new ReverseBetween().solution(head, 1, 2);
        System.out.println(head);
    }

}
