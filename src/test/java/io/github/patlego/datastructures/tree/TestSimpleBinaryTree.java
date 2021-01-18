package io.github.patlego.datastructures.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.github.patlego.datastructures.trees.BinaryTree;
import io.github.patlego.datastructures.trees.Node;
import io.github.patlego.datastructures.trees.impl.SimpleBinaryTree;

public class TestSimpleBinaryTree {

    @Test
    public void testSimpleGetAllNodes() {
        Node root = Mockito.mock(Node.class);
        Mockito.when(root.hasChildren()).thenReturn(Boolean.TRUE);
        
        Node left = Mockito.mock(Node.class);
        Mockito.when(left.hasChildren()).thenReturn(Boolean.FALSE);

        Node right = Mockito.mock(Node.class);
        Mockito.when(right.hasChildren()).thenReturn(Boolean.FALSE);

        Mockito.when(root.getChildren()).thenReturn(Arrays.asList(left, right));
        BinaryTree tree = new SimpleBinaryTree(root);
        assertEquals(3, tree.getAllNodes(root).size());
    }

    @Test
    public void testComplexGetAllNodes() {
        Node root = Mockito.mock(Node.class);
        Mockito.when(root.hasChildren()).thenReturn(Boolean.TRUE);
        
        Node left = Mockito.mock(Node.class);
        Mockito.when(left.hasChildren()).thenReturn(Boolean.TRUE);

        Node left_sibling_1 = Mockito.mock(Node.class);
        Mockito.when(left_sibling_1.hasChildren()).thenReturn(Boolean.FALSE);

        Node left_sibling_2 = Mockito.mock(Node.class);
        Mockito.when(left_sibling_2.hasChildren()).thenReturn(Boolean.FALSE);

        Mockito.when(left.getChildren()).thenReturn(Arrays.asList(left_sibling_1, left_sibling_2));

        Node right = Mockito.mock(Node.class);
        Mockito.when(right.hasChildren()).thenReturn(Boolean.TRUE);

        Node right_sibling_1 = Mockito.mock(Node.class);
        Mockito.when(right_sibling_1.hasChildren()).thenReturn(Boolean.FALSE);

        Mockito.when(right.getChildren()).thenReturn(Arrays.asList(right_sibling_1));


        Mockito.when(root.getChildren()).thenReturn(Arrays.asList(left, right));

        BinaryTree tree = new SimpleBinaryTree(root);
        assertEquals(6, tree.getAllNodes(root).size());
    }
    
}
