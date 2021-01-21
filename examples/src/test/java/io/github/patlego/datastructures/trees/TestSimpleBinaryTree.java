package io.github.patlego.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSimpleBinaryTree {

    @Test
    public void addNode() {
        IntegerBinaryNode value_1 = new IntegerBinaryNode(1);
        IntegerBinaryNode value_2 = new IntegerBinaryNode(2);
        IntegerBinaryNode value_3 = new IntegerBinaryNode(3);

        SimpleBinaryTree tree = new SimpleBinaryTree(value_2);
        tree.add(value_1);

        IntegerBinaryNode root = (IntegerBinaryNode) tree.getRoot();

        assertEquals(1, root.getLeft().getData());

        tree.add(value_3);
        assertEquals(3, root.getRight().getData());
    }

    @Test
    public void deleteNode() {
        IntegerBinaryNode value_1 = new IntegerBinaryNode(1);
        IntegerBinaryNode value_2 = new IntegerBinaryNode(2);
        IntegerBinaryNode value_3 = new IntegerBinaryNode(3);

        SimpleBinaryTree tree = new SimpleBinaryTree(value_2);
        tree.add(value_1);

        IntegerBinaryNode root = (IntegerBinaryNode) tree.getRoot();

        assertEquals(1, root.getLeft().getData());

        tree.add(value_3);
        assertEquals(3, root.getRight().getData());

        tree.delete(value_2);
        assertEquals(3, tree.getRoot().getData());
        assertEquals(1, ((BinaryNode)tree.getRoot()).getLeft().getData());
        assertEquals(null, ((BinaryNode)tree.getRoot()).getRight());
    }
    
}
