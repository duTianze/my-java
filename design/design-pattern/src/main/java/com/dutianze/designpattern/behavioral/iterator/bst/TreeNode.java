package com.dutianze.designpattern.behavioral.iterator.bst;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author dutianze
 * @date 2022/8/10
 */
@Data
public class TreeNode<T extends Comparable<T>> implements Iterable<TreeNode<T>> {

    private final T val;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public void insert(T valToInsert) {
        TreeNode<T> parent = getParentNodeOfValueToBeInserted(valToInsert);
        parent.insertNewChild(valToInsert);
    }

    private TreeNode<T> getParentNodeOfValueToBeInserted(T valToInsert) {
        TreeNode<T> parent = null;
        TreeNode<T> curr = this;

        while (curr != null) {
            parent = curr;
            curr = curr.traverseOneLevelDown(valToInsert);
        }
        return parent;
    }

    private TreeNode<T> traverseOneLevelDown(T value) {
        if (this.isGreaterThan(value)) {
            return this.left;
        }
        return this.right;
    }

    private void insertNewChild(T valToInsert) {
        if (this.isLessThanOrEqualTo(valToInsert)) {
            this.setRight(new TreeNode<>(valToInsert));
        } else {
            this.setLeft(new TreeNode<>(valToInsert));
        }
    }

    private boolean isGreaterThan(T val) {
        return this.val.compareTo(val) > 0;
    }

    private boolean isLessThanOrEqualTo(T val) {
        return this.val.compareTo(val) < 1;
    }

    @Override
    public Iterator<TreeNode<T>> iterator() {
        return new BstIterator<>(this);
    }

    private static class BstIterator<T extends Comparable<T>> implements Iterator<TreeNode<T>> {

        private final ArrayDeque<TreeNode<T>> pathStack;

        public BstIterator(TreeNode<T> root) {
            pathStack = new ArrayDeque<>();
            pushPathToNextSmallest(root);
        }

        @Override
        public boolean hasNext() {
            return !pathStack.isEmpty();
        }

        @Override
        public TreeNode<T> next() throws NoSuchElementException {
            if (pathStack.isEmpty()) {
                throw new NoSuchElementException();
            }
            TreeNode<T> next = pathStack.pop();
            pushPathToNextSmallest(next.getRight());
            return next;
        }

        private void pushPathToNextSmallest(TreeNode<T> node) {
            while (node != null) {
                pathStack.push(node);
                node = node.getLeft();
            }
        }
    }
}
