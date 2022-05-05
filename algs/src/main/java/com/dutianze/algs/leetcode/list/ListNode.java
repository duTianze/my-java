package com.dutianze.algs.leetcode.list;

/**
 * @author dutianze
 * @date 2021/1/3
 */
public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(Integer[] nums) {
        ListNode curr = this;
        for (int i = 0; i < nums.length; i++) {
            curr.val = nums[i];
            if (i < nums.length - 1) {
                curr.next = new ListNode();
            }
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder();
        for (ListNode p = this; p != null; p = p.next) {
            content.append(p.val).append(" -> ");
        }
        content.append("null");
        return content.toString();
    }
}
