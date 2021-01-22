package io.github.patlego.datastructures.trees.avl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doCallRealMethod;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestAVLNode {

    @Test
    public void testHeight() {
        AVLNode root = Mockito.mock(AVLNode.class);

        Mockito.when(root.getHeight()).thenCallRealMethod();
        Mockito.when(root.getLeft()).thenCallRealMethod();
        Mockito.when(root.getRight()).thenCallRealMethod();

        assertEquals(0, root.getHeight());
    }

    @Test
    public void testHeight_Multi() {
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

        assertEquals(1, root.getHeight());

        AVLNode right = Mockito.mock(AVLNode.class);

        doCallRealMethod().when(root).setRight(Mockito.any());
        root.setRight(right);

        Mockito.when(right.getHeight()).thenCallRealMethod();
        Mockito.when(right.getLeft()).thenCallRealMethod();
        Mockito.when(right.getRight()).thenCallRealMethod();

        assertEquals(0, root.getHeight());

    }

    @Test
    public void testHeight_Multi_Two_Level() {
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
    }
    
}
