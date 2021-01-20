package io.github.patlego.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.withSettings;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.github.patlego.datastructures.trees.BinaryNode;
import io.github.patlego.datastructures.trees.BinaryTree;

public class TestBinaryTree {

    @Test
    public void testGetAllNodes() {
        // Root Children

        BinaryNode root = Mockito.mock(BinaryNode.class);
        BinaryNode left = Mockito.mock(BinaryNode.class);
        BinaryNode right = Mockito.mock(BinaryNode.class);

        root.setLeft(left);
        root.setRight(right);

        Mockito.when(root.getLeft()).thenReturn(left);
        Mockito.when(root.getRight()).thenReturn(right);
        
        Mockito.when(root.hasChildren()).thenReturn(Boolean.TRUE);
        Mockito.when(left.hasChildren()).thenReturn(Boolean.TRUE);
        Mockito.when(right.hasChildren()).thenReturn(Boolean.FALSE);

        // Left Children

        BinaryNode left_left = Mockito.mock(BinaryNode.class);
        BinaryNode left_right = Mockito.mock(BinaryNode.class);

        left.setLeft(left_left);
        left.setRight(left_right);

        Mockito.when(left.getLeft()).thenReturn(left_left);
        Mockito.when(left.getRight()).thenReturn(left_right);

        // Binary Tree

        BinaryTree tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.getAllNodes()).thenCallRealMethod();

        assertEquals(5,tree.getAllNodes().size());
    }

    @Test
    public void testAdd() {
        BinaryNode root = Mockito.mock(BinaryNode.class);
        BinaryNode left = Mockito.mock(BinaryNode.class);
        BinaryNode left_left = Mockito.mock(BinaryNode.class);


        Mockito.when(root.hasChildren()).thenCallRealMethod();
        Mockito.when(left.hasChildren()).thenCallRealMethod();
        Mockito.when(left_left.hasChildren()).thenCallRealMethod();

        Mockito.when(root.compareTo(left)).thenReturn(1);
        Mockito.when(root.compareTo(left_left)).thenReturn(1);
        Mockito.when(left.compareTo(left_left)).thenReturn(1);

        BinaryTree<String> tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
       
        Mockito.when(tree.add(Mockito.any())).thenCallRealMethod();
       
        Mockito.when(root.getLeft()).thenCallRealMethod();
        Mockito.when(root.getRight()).thenCallRealMethod();
        doCallRealMethod().when(root).setLeft(Mockito.any());
        doCallRealMethod().when(root).setRight(Mockito.any());
        Mockito.when(left.getData()).thenReturn("Pat");

        tree.add(left);

        assertNotNull(root.getLeft());
        assertEquals("Pat", root.getLeft().getData());
       
        Mockito.when(left.getLeft()).thenCallRealMethod();
        Mockito.when(left.getRight()).thenCallRealMethod();
        doCallRealMethod().when(left).setLeft(Mockito.any());
        doCallRealMethod().when(left).setRight(Mockito.any());
        Mockito.when(left_left.getData()).thenReturn("Serge");

        tree.add(left_left);

        assertNotNull(root.getLeft().getLeft());
        assertEquals("Serge", root.getLeft().getLeft().getData());
    }

    @Test
    public void testGetParent() {
        BinaryNode root = Mockito.mock(BinaryNode.class);
        BinaryNode left = Mockito.mock(BinaryNode.class);
        BinaryNode right = Mockito.mock(BinaryNode.class);

        Mockito.when(root.getData()).thenReturn("root");
        Mockito.when(left.getData()).thenReturn("left");
        Mockito.when(right.getData()).thenReturn("right");

        Mockito.when(root.compareTo("root")).thenReturn(0);
        Mockito.when(left.compareTo("left")).thenReturn(0);
        Mockito.when(right.compareTo("right")).thenReturn(0);
        Mockito.when(root.compareTo("left")).thenReturn(-1);
        Mockito.when(root.compareTo("right")).thenReturn(-1);

        Mockito.when(root.hasChildren()).thenReturn(Boolean.TRUE);
        Mockito.when(left.hasChildren()).thenReturn(Boolean.FALSE);
        Mockito.when(right.hasChildren()).thenReturn(Boolean.FALSE);

        Mockito.when(root.getLeft()).thenReturn(left);
        Mockito.when(root.getRight()).thenReturn(right);

        BinaryTree<String> tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.getParent(Mockito.any())).thenCallRealMethod();

        assertEquals("root", tree.getParent(left).getData());
        assertEquals("root", tree.getParent(right).getData());
    }

    @Test
    public void testExists() {
        BinaryNode root = Mockito.mock(BinaryNode.class);
        BinaryNode left = Mockito.mock(BinaryNode.class);
        BinaryNode right = Mockito.mock(BinaryNode.class);

        Mockito.when(root.getLeft()).thenReturn(left);
        Mockito.when(root.getRight()).thenReturn(right);

        Mockito.when(root.getData()).thenReturn("root");
        Mockito.when(left.getData()).thenReturn("left");
        Mockito.when(right.getData()).thenReturn("right");

        Mockito.when(root.compareTo(root)).thenReturn(0);
        Mockito.when(root.compareTo(left)).thenReturn(-1);
        Mockito.when(root.compareTo(right)).thenReturn(-1);

        Mockito.when(left.compareTo(left)).thenReturn(0);
        Mockito.when(left.compareTo(root)).thenReturn(-1);
        Mockito.when(left.compareTo(right)).thenReturn(-1);

        Mockito.when(right.compareTo(right)).thenReturn(0);
        Mockito.when(right.compareTo(root)).thenReturn(-1);
        Mockito.when(right.compareTo(left)).thenReturn(-1);

        Mockito.when(root.hasChildren()).thenReturn(Boolean.TRUE);
        
        BinaryTree<String> tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.exists(Mockito.any())).thenCallRealMethod();

        assertTrue(tree.exists(right));
    }

    @Test
    public void testFindMin() {
        BinaryNode root = Mockito.mock(BinaryNode.class);
        BinaryNode left = Mockito.mock(BinaryNode.class);
        BinaryNode right = Mockito.mock(BinaryNode.class);

        BinaryNode left_left = Mockito.mock(BinaryNode.class);
        BinaryNode left_right = Mockito.mock(BinaryNode.class);

        Mockito.when(left_left.getData()).thenReturn("Pat");

        Mockito.when(root.getLeft()).thenReturn(left);
        Mockito.when(root.getRight()).thenReturn(right);
        Mockito.when(root.hasChildren()).thenReturn(Boolean.TRUE);

        Mockito.when(left.getLeft()).thenReturn(left_left);
        Mockito.when(left.getRight()).thenReturn(left_right);
        Mockito.when(left.hasChildren()).thenReturn(Boolean.TRUE);

        Mockito.when(right.hasChildren()).thenReturn(Boolean.FALSE);

        BinaryTree<String> tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.findMin(Mockito.any())).thenCallRealMethod();

        assertEquals("Pat", tree.findMin(root).getData());
    }

    @Test
    public void testFindMax() {
        BinaryNode root = Mockito.mock(BinaryNode.class);
        BinaryNode left = Mockito.mock(BinaryNode.class);
        BinaryNode right = Mockito.mock(BinaryNode.class);

        BinaryNode right_left = Mockito.mock(BinaryNode.class);
        BinaryNode right_right = Mockito.mock(BinaryNode.class);

        Mockito.when(right_right.getData()).thenReturn("Pat");

        Mockito.when(root.getLeft()).thenReturn(left);
        Mockito.when(root.getRight()).thenReturn(right);
        Mockito.when(root.hasChildren()).thenReturn(Boolean.TRUE);

        Mockito.when(right.getLeft()).thenReturn(right_left);
        Mockito.when(right.getRight()).thenReturn(right_right);
        Mockito.when(right.hasChildren()).thenReturn(Boolean.TRUE);

        Mockito.when(left.hasChildren()).thenReturn(Boolean.FALSE);

        BinaryTree<String> tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.findMax(Mockito.any())).thenCallRealMethod();

        assertEquals("Pat", tree.findMax(root).getData());
    }

    @Test
    public void testRemove_root() {
        BinaryNode root = Mockito.mock(BinaryNode.class, withSettings().useConstructor(2));
        BinaryNode left = Mockito.mock(BinaryNode.class, withSettings().useConstructor(1));
        BinaryNode right = Mockito.mock(BinaryNode.class, withSettings().useConstructor(3));
        
        Mockito.when(root.getData()).thenCallRealMethod();
        Mockito.when(left.getData()).thenCallRealMethod();
        Mockito.when(right.getData()).thenCallRealMethod();
        
        Mockito.when(root.getLeft()).thenReturn(left);
        Mockito.when(root.getRight()).thenReturn(right);
        Mockito.when(root.hasChildren()).thenReturn(Boolean.TRUE);

        Mockito.when(right.hasChildren()).thenReturn(Boolean.FALSE); 
        Mockito.when(left.hasChildren()).thenReturn(Boolean.FALSE);
        
        Mockito.when(root.compareTo(root)).thenReturn(0);
        Mockito.when(root.compareTo(left)).thenReturn(1);
        Mockito.when(root.compareTo(right)).thenReturn(-1);
        
        Mockito.when(left.compareTo(left)).thenReturn(0);
        Mockito.when(left.compareTo(right)).thenReturn(-1);
        Mockito.when(left.compareTo(root)).thenReturn(-1);

        Mockito.when(right.compareTo(right)).thenReturn(0);
        Mockito.when(right.compareTo(left)).thenReturn(1);
        Mockito.when(right.compareTo(root)).thenReturn(1);

        Mockito.when(root.compareTo(2)).thenReturn(0);
        Mockito.when(root.compareTo(1)).thenReturn(1);
        Mockito.when(root.compareTo(3)).thenReturn(-1);

        Mockito.when(left.compareTo(1)).thenReturn(0);
        Mockito.when(left.compareTo(2)).thenReturn(-1);
        Mockito.when(left.compareTo(3)).thenReturn(-1);

        Mockito.when(right.compareTo(3)).thenReturn(0);
        Mockito.when(right.compareTo(1)).thenReturn(1);
        Mockito.when(right.compareTo(2)).thenReturn(1);
        
        BinaryTree<String> tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.findMin(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.remove(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getParent(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getRoot()).thenCallRealMethod();
        
        doCallRealMethod().when(root).setLeft(Mockito.any());
        doCallRealMethod().when(root).setRight(Mockito.any());

        doCallRealMethod().when(left).setLeft(Mockito.any());
        doCallRealMethod().when(left).setRight(Mockito.any());

        doCallRealMethod().when(right).setLeft(Mockito.any());
        doCallRealMethod().when(right).setRight(Mockito.any());

        assertTrue(tree.remove(root));
        assertEquals(3, root.getData());
    }
    
}
