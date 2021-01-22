package io.github.patlego.datastructures.trees.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.withSettings;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

        assertEquals(5, tree.getAllNodes().size());
    }

    @Test
    public void testAdd() {
        BinaryNode root = Mockito.mock(BinaryNode.class, withSettings().useConstructor(4));
        BinaryNode left = Mockito.mock(BinaryNode.class, withSettings().useConstructor(2));
        BinaryNode left_left = Mockito.mock(BinaryNode.class, withSettings().useConstructor(1));

        Mockito.when(root.hasChildren()).thenCallRealMethod();
        Mockito.when(left.hasChildren()).thenCallRealMethod();
        Mockito.when(left_left.hasChildren()).thenCallRealMethod();

        Mockito.when(root.getData()).thenCallRealMethod();
        Mockito.when(left.getData()).thenCallRealMethod();
        Mockito.when(left_left.getData()).thenCallRealMethod();

        Mockito.when(root.compareTo(2)).thenReturn(1);
        Mockito.when(root.compareTo(1)).thenReturn(1);
        Mockito.when(left.compareTo(1)).thenReturn(1);

        BinaryTree tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.add(Mockito.any())).thenCallRealMethod();

        Mockito.when(root.getLeft()).thenCallRealMethod();
        Mockito.when(root.getRight()).thenCallRealMethod();
        doCallRealMethod().when(root).setLeft(Mockito.any());
        doCallRealMethod().when(root).setRight(Mockito.any());

        tree.add(left);

        assertNotNull(root.getLeft());
        assertEquals(2, root.getLeft().getData());

        Mockito.when(left.getLeft()).thenCallRealMethod();
        Mockito.when(left.getRight()).thenCallRealMethod();
        doCallRealMethod().when(left).setLeft(Mockito.any());
        doCallRealMethod().when(left).setRight(Mockito.any());

        tree.add(left_left);

        assertNotNull(root.getLeft().getLeft());
        assertEquals(1, root.getLeft().getLeft().getData());
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

        BinaryTree tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
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

        BinaryTree tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
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

        BinaryTree tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
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

        BinaryTree tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.findMax(Mockito.any())).thenCallRealMethod();

        assertEquals("Pat", tree.findMax(root).getData());
    }

    @Test
    public void testdelete_root() {
        BinaryNode root = Mockito.mock(BinaryNode.class, withSettings().useConstructor(2));
        BinaryNode left = Mockito.mock(BinaryNode.class, withSettings().useConstructor(1));
        BinaryNode right = Mockito.mock(BinaryNode.class, withSettings().useConstructor(3));

        doCallRealMethod().when(root).setLeft(Mockito.any());
        doCallRealMethod().when(root).setRight(Mockito.any());
        Mockito.when(root.getData()).thenCallRealMethod();

        doCallRealMethod().when(left).setLeft(Mockito.any());
        doCallRealMethod().when(left).setRight(Mockito.any());
        Mockito.when(left.getData()).thenCallRealMethod();

        doCallRealMethod().when(right).setLeft(Mockito.any());
        doCallRealMethod().when(right).setRight(Mockito.any());
        Mockito.when(right.getData()).thenCallRealMethod();

        Mockito.when(root.getLeft()).thenCallRealMethod();
        Mockito.when(root.getRight()).thenCallRealMethod();
        Mockito.when(root.hasChildren()).thenReturn(Boolean.TRUE);
        root.setLeft(left);
        root.setRight(right);

        Mockito.when(right.getLeft()).thenCallRealMethod();
        Mockito.when(right.getRight()).thenCallRealMethod();
        Mockito.when(right.hasChildren()).thenReturn(Boolean.FALSE);

        Mockito.when(left.getLeft()).thenCallRealMethod();
        Mockito.when(left.getRight()).thenCallRealMethod();
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

        BinaryTree tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.findMin(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.delete(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getParent(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getRoot()).thenCallRealMethod();

        assertTrue(tree.delete(root));
        Mockito.verify(root, Mockito.times(1)).setRight(null);
        Mockito.verify(right, Mockito.times(1)).setLeft(left);
    }

    @Test
    public void testdelete_left() {
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

        BinaryTree tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.findMin(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.delete(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getParent(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getRoot()).thenCallRealMethod();

        doCallRealMethod().when(root).setLeft(Mockito.any());
        doCallRealMethod().when(root).setRight(Mockito.any());

        doCallRealMethod().when(left).setLeft(Mockito.any());
        doCallRealMethod().when(left).setRight(Mockito.any());

        doCallRealMethod().when(right).setLeft(Mockito.any());
        doCallRealMethod().when(right).setRight(Mockito.any());

        assertTrue(tree.delete(left));
        assertEquals(2, root.getData());

        Mockito.verify(root, Mockito.times(1)).setLeft(null);
    }

    @Test
    public void testdelete_right() {
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

        BinaryTree tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.findMin(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.delete(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getParent(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getRoot()).thenCallRealMethod();

        doCallRealMethod().when(root).setLeft(Mockito.any());
        doCallRealMethod().when(root).setRight(Mockito.any());

        doCallRealMethod().when(left).setLeft(Mockito.any());
        doCallRealMethod().when(left).setRight(Mockito.any());

        doCallRealMethod().when(right).setLeft(Mockito.any());
        doCallRealMethod().when(right).setRight(Mockito.any());

        assertTrue(tree.delete(right));
        assertEquals(2, root.getData());

        Mockito.verify(root, Mockito.times(1)).setRight(null);
    }

    @Test
    public void testdelete_sub_child() {
        // Create nodes
        BinaryNode root = Mockito.mock(BinaryNode.class, withSettings().useConstructor(3));
        BinaryNode left = Mockito.mock(BinaryNode.class, withSettings().useConstructor(2));
        BinaryNode left_left = Mockito.mock(BinaryNode.class, withSettings().useConstructor(1));
        BinaryNode right = Mockito.mock(BinaryNode.class, withSettings().useConstructor(4));

        // Call real methods when invoked for root
        doCallRealMethod().when(root).setLeft(Mockito.any());
        doCallRealMethod().when(root).setRight(Mockito.any());
        Mockito.when(root.getLeft()).thenCallRealMethod();
        Mockito.when(root.getRight()).thenCallRealMethod();

        // Call real methods when invoked for left
        doCallRealMethod().when(left).setLeft(Mockito.any());
        doCallRealMethod().when(left).setRight(Mockito.any());
        Mockito.when(left.getLeft()).thenCallRealMethod();
        Mockito.when(left.getRight()).thenCallRealMethod();

        // Call real methods when invoked for left_left
        doCallRealMethod().when(left_left).setLeft(Mockito.any());
        doCallRealMethod().when(left_left).setLeft(Mockito.any());
        Mockito.when(left_left.getLeft()).thenCallRealMethod();
        Mockito.when(left_left.getRight()).thenCallRealMethod();

        // Call real methods when invoked for right
        doCallRealMethod().when(right).setLeft(Mockito.any());
        doCallRealMethod().when(right).setRight(Mockito.any());
        Mockito.when(right.getRight()).thenCallRealMethod();
        Mockito.when(right.getLeft()).thenCallRealMethod();

        // Call real methods getData when invoked
        Mockito.when(root.getData()).thenCallRealMethod();
        Mockito.when(left.getData()).thenCallRealMethod();
        Mockito.when(left_left.getData()).thenCallRealMethod();
        Mockito.when(right.getData()).thenCallRealMethod();

        // Set root children and hasChildren definition
        root.setLeft(left);
        root.setRight(right);
        Mockito.when(root.hasChildren()).thenReturn(Boolean.TRUE);

        // Set right to have no children
        Mockito.when(right.hasChildren()).thenReturn(Boolean.FALSE);

        // Set left to have children and hasChildren definition
        Mockito.when(left.hasChildren()).thenReturn(Boolean.TRUE);
        left.setLeft(left_left);

        // Set the results of the comparison
        Mockito.when(root.compareTo(root)).thenReturn(0);
        Mockito.when(root.compareTo(left)).thenReturn(1);
        Mockito.when(root.compareTo(right)).thenReturn(-1);
        Mockito.when(root.compareTo(left_left)).thenReturn(1);

        Mockito.when(left.compareTo(left)).thenReturn(0);
        Mockito.when(left.compareTo(right)).thenReturn(-1);
        Mockito.when(left.compareTo(root)).thenReturn(-1);
        Mockito.when(left.compareTo(left_left)).thenReturn(1);

        Mockito.when(left_left.compareTo(left)).thenReturn(-1);
        Mockito.when(left_left.compareTo(right)).thenReturn(-1);
        Mockito.when(left_left.compareTo(root)).thenReturn(-1);
        Mockito.when(left_left.compareTo(left_left)).thenReturn(0);

        Mockito.when(right.compareTo(right)).thenReturn(0);
        Mockito.when(right.compareTo(left)).thenReturn(1);
        Mockito.when(right.compareTo(root)).thenReturn(1);
        Mockito.when(right.compareTo(left_left)).thenReturn(1);

        Mockito.when(root.compareTo(3)).thenReturn(0);
        Mockito.when(root.compareTo(2)).thenReturn(1);
        Mockito.when(root.compareTo(1)).thenReturn(1);
        Mockito.when(root.compareTo(4)).thenReturn(-1);

        Mockito.when(left.compareTo(1)).thenReturn(1);
        Mockito.when(left.compareTo(2)).thenReturn(0);
        Mockito.when(left.compareTo(3)).thenReturn(-1);
        Mockito.when(left.compareTo(4)).thenReturn(-1);

        Mockito.when(right.compareTo(4)).thenReturn(0);
        Mockito.when(right.compareTo(2)).thenReturn(1);
        Mockito.when(right.compareTo(3)).thenReturn(1);
        Mockito.when(right.compareTo(1)).thenReturn(1);

        Mockito.when(left_left.compareTo(4)).thenReturn(-1);
        Mockito.when(left_left.compareTo(2)).thenReturn(-1);
        Mockito.when(left_left.compareTo(3)).thenReturn(-1);
        Mockito.when(left_left.compareTo(1)).thenReturn(0);

        // Create the binary tree
        BinaryTree tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));

        // Make sure all necessary methods are being invoked
        Mockito.when(tree.findMin(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.delete(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getParent(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getRoot()).thenCallRealMethod();

        // Make sure it was successfull
        assertTrue(tree.delete(left));
        assertEquals(3, root.getData());
        assertEquals(1, root.getLeft().getData());

        Mockito.verify(root, Mockito.times(1)).setLeft(left_left);
    }

    @Test
    public void testdelete_invalid_node() {
        // Create nodes
        BinaryNode root = Mockito.mock(BinaryNode.class, withSettings().useConstructor(3));
        BinaryNode left = Mockito.mock(BinaryNode.class, withSettings().useConstructor(2));
        BinaryNode right = Mockito.mock(BinaryNode.class, withSettings().useConstructor(4));

        // Call real methods when invoked for root
        doCallRealMethod().when(root).setLeft(Mockito.any());
        doCallRealMethod().when(root).setRight(Mockito.any());
        Mockito.when(root.getLeft()).thenCallRealMethod();
        Mockito.when(root.getRight()).thenCallRealMethod();

        // Call real methods when invoked for left
        doCallRealMethod().when(left).setLeft(Mockito.any());
        doCallRealMethod().when(left).setRight(Mockito.any());
        Mockito.when(left.getLeft()).thenCallRealMethod();
        Mockito.when(left.getRight()).thenCallRealMethod();

        // Call real methods when invoked for right
        doCallRealMethod().when(right).setLeft(Mockito.any());
        doCallRealMethod().when(right).setRight(Mockito.any());
        Mockito.when(right.getRight()).thenCallRealMethod();
        Mockito.when(right.getLeft()).thenCallRealMethod();

        // Call real methods getData when invoked
        Mockito.when(root.getData()).thenCallRealMethod();
        Mockito.when(left.getData()).thenCallRealMethod();
        Mockito.when(right.getData()).thenCallRealMethod();

        // Set root children and hasChildren definition
        root.setRight(right);
        Mockito.when(root.hasChildren()).thenReturn(Boolean.TRUE);

        // Set right to have no children
        Mockito.when(right.hasChildren()).thenReturn(Boolean.FALSE);

        // Set left to have children and hasChildren definition
        Mockito.when(left.hasChildren()).thenReturn(Boolean.FALSE);

        // Set the results of the comparison
        Mockito.when(root.compareTo(root)).thenReturn(0);
        Mockito.when(root.compareTo(left)).thenReturn(1);
        Mockito.when(root.compareTo(right)).thenReturn(-1);

        Mockito.when(left.compareTo(left)).thenReturn(0);
        Mockito.when(left.compareTo(right)).thenReturn(-1);
        Mockito.when(left.compareTo(root)).thenReturn(-1);

        Mockito.when(right.compareTo(right)).thenReturn(0);
        Mockito.when(right.compareTo(left)).thenReturn(1);
        Mockito.when(right.compareTo(root)).thenReturn(1);

        Mockito.when(root.compareTo(3)).thenReturn(0);
        Mockito.when(root.compareTo(2)).thenReturn(1);
        Mockito.when(root.compareTo(4)).thenReturn(-1);

        Mockito.when(left.compareTo(2)).thenReturn(0);
        Mockito.when(left.compareTo(3)).thenReturn(-1);
        Mockito.when(left.compareTo(4)).thenReturn(-1);

        Mockito.when(right.compareTo(4)).thenReturn(0);
        Mockito.when(right.compareTo(2)).thenReturn(1);
        Mockito.when(right.compareTo(3)).thenReturn(1);

        // Create the binary tree
        BinaryTree tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));

        // Make sure all necessary methods are being invoked
        Mockito.when(tree.findMin(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.delete(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getParent(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getRoot()).thenCallRealMethod();

        // Make sure it was successfull
        assertTrue(!tree.delete(left));

    }

    @Test
    public void getNode() {
        // Create nodes
        BinaryNode root = Mockito.mock(BinaryNode.class, withSettings().useConstructor(3));
        BinaryNode left = Mockito.mock(BinaryNode.class, withSettings().useConstructor(2));
        BinaryNode right = Mockito.mock(BinaryNode.class, withSettings().useConstructor(4));

        // Call real methods when invoked for root
        doCallRealMethod().when(root).setLeft(Mockito.any());
        doCallRealMethod().when(root).setRight(Mockito.any());
        Mockito.when(root.getLeft()).thenCallRealMethod();
        Mockito.when(root.getRight()).thenCallRealMethod();

        // Call real methods when invoked for left
        doCallRealMethod().when(left).setLeft(Mockito.any());
        doCallRealMethod().when(left).setRight(Mockito.any());
        Mockito.when(left.getLeft()).thenCallRealMethod();
        Mockito.when(left.getRight()).thenCallRealMethod();

        // Call real methods when invoked for right
        doCallRealMethod().when(right).setLeft(Mockito.any());
        doCallRealMethod().when(right).setRight(Mockito.any());
        Mockito.when(right.getRight()).thenCallRealMethod();
        Mockito.when(right.getLeft()).thenCallRealMethod();

        root.setLeft(left);
        root.setRight(right);

        Mockito.when(root.compareTo(3)).thenReturn(0);
        Mockito.when(root.compareTo(2)).thenReturn(1);
        Mockito.when(root.compareTo(4)).thenReturn(-1);

        Mockito.when(left.compareTo(3)).thenReturn(-1);
        Mockito.when(left.compareTo(2)).thenReturn(0);
        Mockito.when(left.compareTo(4)).thenReturn(-1);

        Mockito.when(right.compareTo(3)).thenReturn(1);
        Mockito.when(right.compareTo(2)).thenReturn(1);
        Mockito.when(right.compareTo(4)).thenReturn(0);

        // Create the binary tree
        BinaryTree tree = Mockito.mock(BinaryTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.get(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.exists(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getRoot()).thenCallRealMethod();

        assertEquals(left.hashCode(),tree.get(left).hashCode());
        assertEquals(right.hashCode(),tree.get(right).hashCode());
        assertEquals(root.hashCode(),tree.get(root).hashCode());
    }

}
