package com.dutianze.algs.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author dutianze
 * @date 2022/5/25
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode() {}

    public TreeNode(Integer val) {this.val = val;}

    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public TreeNode getLeft() {
        return this.left;
    }


    public TreeNode getRight() {
        return this.right;
    }


    public String getText() {
        return String.valueOf(this.val);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
               "val=" + val +
               ", left=" + left +
               ", right=" + right +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        TreeNode treeNode = (TreeNode) o;
        return Objects.equals(val, treeNode.val) && Objects.equals(left, treeNode.left) &&
               Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    /**
     * Print a tree
     */
    public void print() {
        List<List<String>> lines = new ArrayList<>();

        List<TreeNode> level = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();

        level.add(this);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();

            nn = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.getText();
                    line.add(aa);
                    if (aa.length() > widest) {widest = aa.length();}

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) {nn++;}
                    if (n.getRight() != null) {nn++;}
                }
            }

            if (widest % 2 == 1) {widest++;}

            lines.add(line);

            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int percipience = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(percipience / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (line.get(j) != null) {c = '└';}
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < percipience - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (String f : line) {

                if (f == null) {f = "";}
                float a = percipience / 2f - f.length() / 2f;
                int gap1 = (int) Math.ceil(a);
                int gap2 = (int) Math.floor(a);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            percipience /= 2;
        }
    }
}