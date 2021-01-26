package io.github.patlego.datastructures.trees.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSimpleDuplicateBinaryTree {

    @Test
    public void testSize() {
        DuplicateBinaryNode root = new IntegerDuplicateBinaryNode(3);
        DuplicateBinaryNode left = new IntegerDuplicateBinaryNode(2);
        DuplicateBinaryNode right = new IntegerDuplicateBinaryNode(4);
        DuplicateBinaryTree tree = new SimpleDuplicateBinaryTree(root);

        tree.add(root);
        tree.add(left);
        tree.add(right);
        assertEquals(4, tree.size());
    }

    @Test
    public void testDelete() {
        DuplicateBinaryNode root = new IntegerDuplicateBinaryNode(3);
        DuplicateBinaryNode left = new IntegerDuplicateBinaryNode(2);
        DuplicateBinaryNode right = new IntegerDuplicateBinaryNode(4);
        DuplicateBinaryTree tree = new SimpleDuplicateBinaryTree(root);

        tree.add(root);
        tree.add(left);
        tree.add(right);

        tree.delete(root);
        assertEquals(1, root.getCount());
        assertEquals(3, tree.size());

        tree.delete(root);
        assertEquals(2, tree.size());
    }
    
}
