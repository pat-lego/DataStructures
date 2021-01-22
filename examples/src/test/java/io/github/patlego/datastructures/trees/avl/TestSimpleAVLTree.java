package io.github.patlego.datastructures.trees.avl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestSimpleAVLTree {

    // @Test
    // public void testAVLTreeHeight() {
    //     SimpleAVLNode avl_10 = new SimpleAVLNode(10);
    //     SimpleAVLNode avl_5 = new SimpleAVLNode(5);
    //     SimpleAVLNode avl_4 = new SimpleAVLNode(4);
    //     SimpleAVLNode avl_6 = new SimpleAVLNode(6);
    //     SimpleAVLNode avl_7 = new SimpleAVLNode(7);
    //     SimpleAVLNode avl_8 = new SimpleAVLNode(8);
    //     SimpleAVLNode avl_13 = new SimpleAVLNode(13);
    //     SimpleAVLNode avl_17 = new SimpleAVLNode(17);

    //     IntegerAVLTree tree = new IntegerAVLTree(avl_10);
    //     assertTrue(tree.add(avl_5));
    //     assertTrue(tree.add(avl_13));
    //     assertTrue(tree.add(avl_17));
    //     assertTrue(tree.add(avl_4));
    //     assertTrue(tree.add(avl_6));
    //     assertTrue(tree.add(avl_7));
    //     assertTrue(tree.add(avl_8));

    //     AVLNode root = (AVLNode) tree.getRoot();
    //     assertEquals(5, root.getLeft().getData());
    //     assertEquals(4, root.getLeft().getLeft().getData());
    //     assertEquals(6, root.getLeft().getRight().getData());
    //     assertEquals(7, root.getLeft().getRight().getRight().getData());
    //     assertEquals(8, root.getLeft().getRight().getRight().getRight().getData());
    //     assertEquals(13, root.getRight().getData());
    //     assertEquals(17, root.getRight().getRight().getData());
    //     assertEquals(null, root.getRight().getRight().getRight());

    //     assertEquals(2, root.getHeight());

    // }

    @Test
    public void testAVL_LL_root() {
        SimpleAVLNode avl_3 = new SimpleAVLNode(3);
        SimpleAVLNode avl_2 = new SimpleAVLNode(2);
        SimpleAVLNode avl_1 = new SimpleAVLNode(1);
        

        IntegerAVLTree tree = new IntegerAVLTree(avl_3);
        assertTrue(tree.add(avl_2));
        assertTrue(tree.add(avl_1));

        assertEquals(2, tree.getRoot().getData());
        assertEquals(1, ((AVLNode) tree.getRoot()).getLeft().getData());
        assertEquals(null, ((AVLNode) tree.getRoot()).getLeft().getRight());
        assertEquals(null, ((AVLNode) tree.getRoot()).getLeft().getLeft());
        assertEquals(3, ((AVLNode) tree.getRoot()).getRight().getData());
        assertEquals(null, ((AVLNode) tree.getRoot()).getRight().getRight());
        assertEquals(null, ((AVLNode) tree.getRoot()).getRight().getLeft());
        
    }

    @Test
    public void testAVL_RR_root() {
        SimpleAVLNode avl_3 = new SimpleAVLNode(3);
        SimpleAVLNode avl_2 = new SimpleAVLNode(2);
        SimpleAVLNode avl_1 = new SimpleAVLNode(1);
        

        IntegerAVLTree tree = new IntegerAVLTree(avl_1);
        assertTrue(tree.add(avl_2));
        assertTrue(tree.add(avl_3));

        assertEquals(2, tree.getRoot().getData());
        assertEquals(1, ((AVLNode) tree.getRoot()).getLeft().getData());
        assertEquals(null, ((AVLNode) tree.getRoot()).getLeft().getRight());
        assertEquals(null, ((AVLNode) tree.getRoot()).getLeft().getLeft());
        assertEquals(3, ((AVLNode) tree.getRoot()).getRight().getData());
        assertEquals(null, ((AVLNode) tree.getRoot()).getRight().getRight());
        assertEquals(null, ((AVLNode) tree.getRoot()).getRight().getLeft());
        
    }

    @Test
    public void testAVL_LL() {
        SimpleAVLNode avl_6 = new SimpleAVLNode(6);
        SimpleAVLNode avl_8 = new SimpleAVLNode(8);
        SimpleAVLNode avl_3 = new SimpleAVLNode(3);
        SimpleAVLNode avl_2 = new SimpleAVLNode(2);
        SimpleAVLNode avl_1 = new SimpleAVLNode(1);
        

        IntegerAVLTree tree = new IntegerAVLTree(avl_6);
        assertTrue(tree.add(avl_3));
        assertTrue(tree.add(avl_8));
        assertTrue(tree.add(avl_2));
        assertTrue(tree.add(avl_1));

        assertEquals(6, tree.getRoot().getData());
        assertEquals(2, ((AVLNode) tree.getRoot()).getLeft().getData());
        assertEquals(8, ((AVLNode) tree.getRoot()).getRight().getData());
        assertEquals(3, ((AVLNode) tree.getRoot()).getLeft().getRight().getData());
        assertEquals(1, ((AVLNode) tree.getRoot()).getLeft().getLeft().getData());
        
    }

    @Test
    public void testAVL_RR() {
        SimpleAVLNode avl_2 = new SimpleAVLNode(2);
        SimpleAVLNode avl_1 = new SimpleAVLNode(1);
        SimpleAVLNode avl_3 = new SimpleAVLNode(3);
        SimpleAVLNode avl_6 = new SimpleAVLNode(6);
        SimpleAVLNode avl_8 = new SimpleAVLNode(8);

        
        IntegerAVLTree tree = new IntegerAVLTree(avl_2);
        assertTrue(tree.add(avl_1));
        assertTrue(tree.add(avl_3));
        assertTrue(tree.add(avl_6));
        assertTrue(tree.add(avl_8));

        assertEquals(2, tree.getRoot().getData());
        assertEquals(1, ((AVLNode) tree.getRoot()).getLeft().getData());
        assertEquals(6, ((AVLNode) tree.getRoot()).getRight().getData());
        assertEquals(3, ((AVLNode) tree.getRoot()).getRight().getLeft().getData());
        assertEquals(8, ((AVLNode) tree.getRoot()).getRight().getRight().getData());
        
    }
    
}
