package io.github.patlego.datastructures.trees.avl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.withSettings;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestAVLTree {

    @Test
    public void testIsOffBalance() {
        AVLNode root = Mockito.mock(AVLNode.class, withSettings().useConstructor("root"));
        AVLNode left = Mockito.mock(AVLNode.class, withSettings().useConstructor("left"));
        AVLNode left_left = Mockito.mock(AVLNode.class, withSettings().useConstructor("left_left"));

        Mockito.when(root.getHeight()).thenCallRealMethod();
        Mockito.when(root.getLeft()).thenCallRealMethod();
        Mockito.when(root.getRight()).thenCallRealMethod();

        doCallRealMethod().when(root).setLeft(Mockito.any());
        root.setLeft(left);

        Mockito.when(left.getHeight()).thenCallRealMethod();
        Mockito.when(left.getLeft()).thenCallRealMethod();
        Mockito.when(left.getRight()).thenCallRealMethod();

        doCallRealMethod().when(left).setLeft(Mockito.any());
        left.setLeft(left_left);

        Mockito.when(left_left.getHeight()).thenCallRealMethod();
        Mockito.when(left_left.getLeft()).thenCallRealMethod();
        Mockito.when(left_left.getRight()).thenCallRealMethod();

        assertEquals(2, root.getHeight());

        AVLTree tree = Mockito.mock(AVLTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.isOffBalance()).thenCallRealMethod();
        Mockito.when(tree.isNodeOffBalance(Mockito.any())).thenCallRealMethod();

        assertTrue(tree.isOffBalance());
    }

    @Test
    public void testGetOffBalance() {
        AVLNode root = Mockito.mock(AVLNode.class);
        AVLNode left = Mockito.mock(AVLNode.class);
        AVLNode left_left = Mockito.mock(AVLNode.class);
     
        Mockito.when(root.getHeight()).thenCallRealMethod();
        Mockito.when(root.getLeft()).thenCallRealMethod();
        Mockito.when(root.getRight()).thenCallRealMethod();

        doCallRealMethod().when(root).setLeft(Mockito.any());
        root.setLeft(left);

        Mockito.when(left.getHeight()).thenCallRealMethod();
        Mockito.when(left.getLeft()).thenCallRealMethod();
        Mockito.when(left.getRight()).thenCallRealMethod();

        doCallRealMethod().when(left).setLeft(Mockito.any());
        left.setLeft(left_left);

        Mockito.when(left_left.getHeight()).thenCallRealMethod();
        Mockito.when(left_left.getLeft()).thenCallRealMethod();
        Mockito.when(left_left.getRight()).thenCallRealMethod();

        assertEquals(2, root.getHeight());

        AVLTree tree = Mockito.mock(AVLTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.getMinOffBalanceNode()).thenCallRealMethod();
        Mockito.when(tree.isNodeOffBalance(Mockito.any())).thenCallRealMethod();
        Mockito.when(tree.getRoot()).thenCallRealMethod();

        assertEquals(root.hashCode(), tree.getMinOffBalanceNode().hashCode());
    }

    @Test
    public void testIsOffBalance_False() {
        AVLNode root = Mockito.mock(AVLNode.class);
        AVLNode left = Mockito.mock(AVLNode.class);
       
        Mockito.when(root.getHeight()).thenCallRealMethod();
        Mockito.when(root.getLeft()).thenCallRealMethod();
        Mockito.when(root.getRight()).thenCallRealMethod();

        doCallRealMethod().when(root).setLeft(Mockito.any());
        root.setLeft(left);

        Mockito.when(left.getHeight()).thenCallRealMethod();
        Mockito.when(left.getLeft()).thenCallRealMethod();
        Mockito.when(left.getRight()).thenCallRealMethod();

        doCallRealMethod().when(left).setLeft(Mockito.any());

        assertEquals(1, root.getHeight());

        AVLTree tree = Mockito.mock(AVLTree.class, withSettings().useConstructor(root));
        Mockito.when(tree.isOffBalance()).thenCallRealMethod();

        assertTrue(!tree.isOffBalance());
    }

}
