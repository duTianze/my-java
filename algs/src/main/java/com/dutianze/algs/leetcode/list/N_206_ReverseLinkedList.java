package com.dutianze.algs.leetcode.list;

/**
 * @author dutianze
 * @date 2022/5/5
 */
public class N_206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
