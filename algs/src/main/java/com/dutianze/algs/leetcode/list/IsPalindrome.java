package com.dutianze.algs.leetcode.list;

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 * @author dutianze
 * @date 2021/1/3
 */
public class IsPalindrome {

    public static boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);

        while (right != null) {
            if (!left.val.equals(right.val)) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;

            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 2, 1};
//        ListNode head = new ListNode(a);
//        System.out.println(head);
//
//        System.out.println(isPalindrome(head));
    }
}
