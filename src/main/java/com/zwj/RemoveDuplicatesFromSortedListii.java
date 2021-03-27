package com.zwj;

import java.util.List;

/*** 
 * description: 删除排序链表中的重复元素 II
 * @param: LeetCodeLink:https://leetcode-cn.com/problems/Remove-duplicates-from-sorted-list-ii/
 * @return:
 * @author zwj
 * @date: 2021/3/27 22:46
 */
public class RemoveDuplicatesFromSortedListii {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode _head = new ListNode(-1);
        ListNode _result = _head;
        _head.next = head;
        ListNode pre = _head;
        _head = _head.next;
        while (_head.next != null) {
            if (_head.next.val == _head.val) {
                while (_head.next != null && _head.next.val == _head.val) {
                    _head = _head.next;
                }
                pre.next = _head.next;
                if (_head.next == null) {
                    return _result.next;
                }
                _head = _head.next;
                continue;
            }

            pre = _head;
            _head = _head.next;
        }
        return _result.next;
    }
}
