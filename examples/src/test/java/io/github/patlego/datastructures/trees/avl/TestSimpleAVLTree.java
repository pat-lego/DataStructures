package io.github.patlego.datastructures.trees.avl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestSimpleAVLTree {

    @Test
    public void testAVLTreeHeight() {
        SimpleAVLNode avl_10 = new SimpleAVLNode(10);
        SimpleAVLNode avl_5 = new SimpleAVLNode(5);
        SimpleAVLNode avl_4 = new SimpleAVLNode(4);
        SimpleAVLNode avl_6 = new SimpleAVLNode(6);
        SimpleAVLNode avl_7 = new SimpleAVLNode(7);
        SimpleAVLNode avl_8 = new SimpleAVLNode(8);
        SimpleAVLNode avl_13 = new SimpleAVLNode(13);
        SimpleAVLNode avl_17 = new SimpleAVLNode(17);

        IntegerAVLTree tree = new IntegerAVLTree(avl_10);
        assertTrue(tree.add(avl_5));
        assertTrue(tree.add(avl_13));
        assertTrue(tree.add(avl_17));
        assertTrue(tree.add(avl_4));
        assertTrue(tree.add(avl_6));
        assertTrue(tree.add(avl_7));
        assertTrue(tree.add(avl_8));

        AVLNode root = (AVLNode) tree.getRoot();
        assertEquals(5, root.getLeft().getData());
        assertEquals(4, root.getLeft().getLeft().getData());
        assertEquals(6, root.getLeft().getRight().getData());
        assertEquals(7, root.getLeft().getRight().getRight().getData());
        assertEquals(8, root.getLeft().getRight().getRight().getRight().getData());
        assertEquals(13, root.getRight().getData());
        assertEquals(17, root.getRight().getRight().getData());
        assertEquals(null, root.getRight().getRight().getRight());

        assertEquals(2, root.getHeight());

    }
    
}
