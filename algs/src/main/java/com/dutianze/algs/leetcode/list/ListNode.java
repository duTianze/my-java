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
