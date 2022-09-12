package com.dutianze.designpattern.behavioral.iterator.bst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * @author dutianze
 * @date 2022/8/10
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TreeNodeTest {

  private TreeNode<Integer> nonEmptyRoot;

  @BeforeAll
  void createTrees() {
    nonEmptyRoot = new TreeNode<>(5);
    nonEmptyRoot.insert(3);
    nonEmptyRoot.insert(7);
    nonEmptyRoot.insert(1);
    nonEmptyRoot.insert(4);
    nonEmptyRoot.insert(6);
  }

  @Test
  void nextOverEntirePopulatedTree() {
    Iterator<TreeNode<Integer>> iterator = nonEmptyRoot.iterator();
    assertEquals(Integer.valueOf(1), iterator.next().getVal(), "First Node is 1.");
    assertEquals(Integer.valueOf(3), iterator.next().getVal(), "Second Node is 3.");
    assertEquals(Integer.valueOf(4), iterator.next().getVal(), "Third Node is 4.");
    assertEquals(Integer.valueOf(5), iterator.next().getVal(), "Fourth Node is 5.");
    assertEquals(Integer.valueOf(6), iterator.next().getVal(), "Fifth Node is 6.");
    assertEquals(Integer.valueOf(7), iterator.next().getVal(), "Sixth Node is 7.");
  }
}