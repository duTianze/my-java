package com.dutianze.algs.leetcode.list;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">206. Reverse Linked List</a>
 * <h2>Easy</h2>
 * <pre>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Constraints:
 *   The number of nodes in the list is the range [0, 5000].
 *   -5000 <= Node.val <= 5000
 * </pre>
 *
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

    public ListNode reverseListLoop(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
