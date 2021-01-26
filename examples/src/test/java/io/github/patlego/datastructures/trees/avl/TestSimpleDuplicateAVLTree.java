package io.github.patlego.datastructures.trees.avl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSimpleDuplicateAVLTree {

    @Test
    public void testSize() {
        DuplicateAVLNode root = new IntegerDuplicateAVLNode(3);
        DuplicateAVLNode left = new IntegerDuplicateAVLNode(2);
        DuplicateAVLNode left_left = new IntegerDuplicateAVLNode(1);
        DuplicateAVLNode right = new IntegerDuplicateAVLNode(4);
        DuplicateAVLTree tree = new SimpleDuplicateAVLTree(root);

        tree.add(root);
        tree.add(left);
        tree.add(left_left);
        tree.add(right);
        assertEquals(5, tree.size());
        assertEquals(2, tree.getRoot().getData());
    }

    @Test
    public void testDelete() {
        DuplicateAVLNode root = new IntegerDuplicateAVLNode(3);
        DuplicateAVLNode left = new IntegerDuplicateAVLNode(2);
        DuplicateAVLNode right = new IntegerDuplicateAVLNode(4);
        DuplicateAVLTree tree = new SimpleDuplicateAVLTree(root);


        tree.add(root);
        tree.add(left);
        tree.add(right);

        tree.delete(root);
        assertEquals(1, root.getCount());
        assertEquals(3, tree.size());

        tree.delete(root);
        assertEquals(2, tree.size());
        assertEquals(4, tree.getRoot().getData());
        assertEquals(2, ((DuplicateAVLNode) tree.getRoot()).getLeft().getData());
    }
    
}
