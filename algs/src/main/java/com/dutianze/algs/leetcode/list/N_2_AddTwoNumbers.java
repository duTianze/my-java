package com.dutianze.algs.leetcode.list;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">2. Add Two Numbers</a>
 * <h2>Medium</h2>
 * <pre>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Constraints:
 *
 *     The number of nodes in each linked list is in the range [1, 100].
 *     0 <= Node.val <= 9
 *     It is guaranteed that the list represents a number that does not have leading zeros.
 * </pre>
 *
 * @author dutianze
 * @date 2022/5/12
 */
public class N_2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null || carry != 0) {
            if (p != null) {
                carry += p.val;
                p = p.next;
            }
            if (q != null) {
                carry += q.val;
                q = q.next;
            }
            curr.next = new ListNode(carry % 10);
            carry /= 10;
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
