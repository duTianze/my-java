package com.dutianze.algs.leetcode.list;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author dutianze
 * @date 2021/1/3
 */
public class ListNode {

    public Integer val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(Integer val) {
        this.val = val;
    }

    public static ListNode of(Integer[] nums) {
        ArrayUtils.reverse(nums);
        return Arrays.stream(nums)
                     .map(ListNode::new)
                     .reduce(null, (pre, curr) -> {
                         curr.next = pre;
                         return curr;
                     });
    }

    public static ListNode with(Integer[] nums) {
        ListNode curr = new ListNode();
        ListNode head = curr;
        for (int i = 0; i < nums.length; i++) {
            curr.val = nums[i];
            if (i < nums.length - 1) {
                curr.next = new ListNode();
            }
            curr = curr.next;
        }
        return head;
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
