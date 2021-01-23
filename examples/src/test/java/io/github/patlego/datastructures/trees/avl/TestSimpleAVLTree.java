package io.github.patlego.datastructures.trees.avl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestSimpleAVLTree {

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
    public void testAVL_LL_layered() {
        SimpleAVLNode avl_6 = new SimpleAVLNode(6);
        SimpleAVLNode avl_8 = new SimpleAVLNode(8);
        SimpleAVLNode avl_7 = new SimpleAVLNode(7);
        SimpleAVLNode avl_9 = new SimpleAVLNode(9);
        SimpleAVLNode avl_3 = new SimpleAVLNode(3);
        SimpleAVLNode avl_2 = new SimpleAVLNode(2);
        SimpleAVLNode avl_1 = new SimpleAVLNode(1);
        SimpleAVLNode avl_neg_1 = new SimpleAVLNode(-1);
        

        IntegerAVLTree tree = new IntegerAVLTree(avl_6);
        assertTrue(tree.add(avl_3));
        assertTrue(tree.add(avl_8));
        assertTrue(tree.add(avl_7));
        assertTrue(tree.add(avl_9));
        assertTrue(tree.add(avl_2));
        assertTrue(tree.add(avl_1));
        assertTrue(tree.add(avl_neg_1));

        assertEquals(6, tree.getRoot().getData());
        assertEquals(2, ((AVLNode) tree.getRoot()).getLeft().getData());
        assertEquals(8, ((AVLNode) tree.getRoot()).getRight().getData());
        assertEquals(7, ((AVLNode) tree.getRoot()).getRight().getLeft().getData());
        assertEquals(9, ((AVLNode) tree.getRoot()).getRight().getRight().getData());
        assertEquals(3, ((AVLNode) tree.getRoot()).getLeft().getRight().getData());
        assertEquals(1, ((AVLNode) tree.getRoot()).getLeft().getLeft().getData());
        
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
