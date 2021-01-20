package io.github.patlego.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    
}
