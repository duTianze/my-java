package com.dutianze.algs.leetcode.list;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">92. Reverse Linked List II</a>
 * <h2>Medium</h2>
 * <pre>
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 * Constraints:
 *
 *     The number of nodes in the list is n.
 *     1 <= n <= 500
 *     -500 <= Node.val <= 500
 *     1 <= left <= right <= n
 *
 * Follow up: Could you do it in one pass?
 * </pre>
 * @author dutianze
 * @date 2022/5/11
 */
public class N_92_ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left -1, right -1);
        return head;
    }

    private ListNode successor = null;

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
