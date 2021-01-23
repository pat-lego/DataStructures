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
    public void testAVL_LL_layered_1() {
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
    public void testAVL_LL_layered_2() {
        SimpleAVLNode avl_16 = new SimpleAVLNode(16);
        SimpleAVLNode avl_18 = new SimpleAVLNode(18);
        SimpleAVLNode avl_3 = new SimpleAVLNode(3);
        SimpleAVLNode avl_17 = new SimpleAVLNode(17);
        SimpleAVLNode avl_19 = new SimpleAVLNode(19);
        SimpleAVLNode avl_2 = new SimpleAVLNode(2);
        SimpleAVLNode avl_13 = new SimpleAVLNode(13);
        SimpleAVLNode avl_14 = new SimpleAVLNode(14);
        SimpleAVLNode avl_15 = new SimpleAVLNode(15);

        IntegerAVLTree tree = new IntegerAVLTree(avl_16);
        assertTrue(tree.add(avl_18));
        assertTrue(tree.add(avl_3));
        assertTrue(tree.add(avl_17));
        assertTrue(tree.add(avl_19));
        assertTrue(tree.add(avl_2));
        assertTrue(tree.add(avl_13));
        assertTrue(tree.add(avl_14));
        assertTrue(tree.add(avl_15));

        assertEquals(16, tree.getRoot().getData());
        assertEquals(3, ((AVLNode) tree.getRoot()).getLeft().getData());
        assertEquals(18, ((AVLNode) tree.getRoot()).getRight().getData());
        assertEquals(14, ((AVLNode) tree.getRoot()).getLeft().getRight().getData());
        assertEquals(15, ((AVLNode) tree.getRoot()).getLeft().getRight().getRight().getData());
        assertEquals(13, ((AVLNode) tree.getRoot()).getLeft().getRight().getLeft().getData());
        
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

    @Test
    public void testAVL_LR_root() {
        SimpleAVLNode avl_5 = new SimpleAVLNode(5);
        SimpleAVLNode avl_3 = new SimpleAVLNode(3);
        SimpleAVLNode avl_4 = new SimpleAVLNode(4);
        
        IntegerAVLTree tree = new IntegerAVLTree(avl_5);
        assertTrue(tree.add(avl_3));
        assertTrue(tree.add(avl_4));

        assertEquals(4, tree.getRoot().getData());
        assertEquals(3, ((AVLNode) tree.getRoot()).getLeft().getData());
        assertEquals(5, ((AVLNode) tree.getRoot()).getRight().getData());
    }

    @Test
    public void testAVL_LR_left() {
        SimpleAVLNode avl_10 = new SimpleAVLNode(10);
        SimpleAVLNode avl_15 = new SimpleAVLNode(15);
        SimpleAVLNode avl_8 = new SimpleAVLNode(8);
        SimpleAVLNode avl_6 = new SimpleAVLNode(6);
        SimpleAVLNode avl_7 = new SimpleAVLNode(7);
        
        IntegerAVLTree tree = new IntegerAVLTree(avl_10);
        assertTrue(tree.add(avl_15));
        assertTrue(tree.add(avl_8));
        assertTrue(tree.add(avl_6));
        assertTrue(tree.add(avl_7));

        assertEquals(10, tree.getRoot().getData());
        assertEquals(7, ((AVLNode) tree.getRoot()).getLeft().getData());
        assertEquals(6, ((AVLNode) tree.getRoot()).getLeft().getLeft().getData());
        assertEquals(8, ((AVLNode) tree.getRoot()).getLeft().getRight().getData());
        assertEquals(15, ((AVLNode) tree.getRoot()).getRight().getData());
    }

    @Test
    public void testAVL_LR_right() {
        SimpleAVLNode avl_10 = new SimpleAVLNode(10);
        SimpleAVLNode avl_6 = new SimpleAVLNode(6);
        SimpleAVLNode avl_15 = new SimpleAVLNode(15);
        SimpleAVLNode avl_13 = new SimpleAVLNode(13);
        SimpleAVLNode avl_14 = new SimpleAVLNode(14);

        
        IntegerAVLTree tree = new IntegerAVLTree(avl_10);
        assertTrue(tree.add(avl_6));
        assertTrue(tree.add(avl_15));
        assertTrue(tree.add(avl_13));
        assertTrue(tree.add(avl_14));

        assertEquals(10, tree.getRoot().getData());
        assertEquals(6, ((AVLNode) tree.getRoot()).getLeft().getData());
        assertEquals(14, ((AVLNode) tree.getRoot()).getRight().getData());
        assertEquals(13, ((AVLNode) tree.getRoot()).getRight().getLeft().getData());
        assertEquals(15, ((AVLNode) tree.getRoot()).getRight().getRight().getData());
    }

    @Test
    public void testAVL_RL_root() {
        SimpleAVLNode avl_16 = new SimpleAVLNode(16);
        SimpleAVLNode avl_19 = new SimpleAVLNode(19);
        SimpleAVLNode avl_18 = new SimpleAVLNode(18);
        
        IntegerAVLTree tree = new IntegerAVLTree(avl_16);
        assertTrue(tree.add(avl_19));
        assertTrue(tree.add(avl_18));

        assertEquals(18, tree.getRoot().getData());
        assertEquals(16, ((AVLNode) tree.getRoot()).getLeft().getData());
        assertEquals(19, ((AVLNode) tree.getRoot()).getRight().getData());
    }

    @Test
    public void testAVL_RL_left() {
        SimpleAVLNode avl_20 = new SimpleAVLNode(20);
        SimpleAVLNode avl_16 = new SimpleAVLNode(16);
        SimpleAVLNode avl_22 = new SimpleAVLNode(22);
        SimpleAVLNode avl_19 = new SimpleAVLNode(19);
        SimpleAVLNode avl_18 = new SimpleAVLNode(18);
        
        IntegerAVLTree tree = new IntegerAVLTree(avl_20);
        assertTrue(tree.add(avl_16));
        assertTrue(tree.add(avl_22));
        assertTrue(tree.add(avl_19));
        assertTrue(tree.add(avl_18));

        assertEquals(20, tree.getRoot().getData());
        assertEquals(18, ((AVLNode) tree.getRoot()).getLeft().getData());
        assertEquals(22, ((AVLNode) tree.getRoot()).getRight().getData());
        assertEquals(16, ((AVLNode) tree.getRoot()).getLeft().getLeft().getData());
        assertEquals(19, ((AVLNode) tree.getRoot()).getLeft().getRight().getData());
    }

    @Test
    public void testAVL_RL_right() {
        SimpleAVLNode avl_20 = new SimpleAVLNode(20);
        SimpleAVLNode avl_30 = new SimpleAVLNode(30);
        SimpleAVLNode avl_10 = new SimpleAVLNode(10);
        SimpleAVLNode avl_35 = new SimpleAVLNode(35);
        SimpleAVLNode avl_32 = new SimpleAVLNode(32);
        
        IntegerAVLTree tree = new IntegerAVLTree(avl_20);
        assertTrue(tree.add(avl_30));
        assertTrue(tree.add(avl_10));
        assertTrue(tree.add(avl_35));
        assertTrue(tree.add(avl_32));

        assertEquals(20, tree.getRoot().getData());
        assertEquals(10, ((AVLNode) tree.getRoot()).getLeft().getData());
        assertEquals(32, ((AVLNode) tree.getRoot()).getRight().getData());
        assertEquals(35, ((AVLNode) tree.getRoot()).getRight().getRight().getData());
        assertEquals(30, ((AVLNode) tree.getRoot()).getRight().getLeft().getData());
    }
    
}
