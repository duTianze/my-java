package com.dutianze.algs.leetcode.list;

/**
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * @author dutianze
 * @date 2021/1/3
 */
public class ReverseBetween {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m -1, n -1);
        return head;
    }

    private static ListNode successor = null;

    private static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {
//        Integer[] a = {1, 2, 3, 4, 5};
//        ListNode root = new ListNode(a);
//        System.out.println(root);
//
//        ListNode reverseBetween = reverseBetween(root, 2, 4);
//        System.out.println(reverseBetween);
    }
}
