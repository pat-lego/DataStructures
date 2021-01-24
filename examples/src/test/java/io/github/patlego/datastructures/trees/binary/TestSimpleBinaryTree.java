package io.github.patlego.datastructures.trees.binary;

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
    public void getNode() {
        IntegerBinaryNode value_1 = new IntegerBinaryNode(1);
        IntegerBinaryNode value_2 = new IntegerBinaryNode(2);
        IntegerBinaryNode value_3 = new IntegerBinaryNode(3);

        SimpleBinaryTree tree = new SimpleBinaryTree(value_2);
        tree.add(value_1);

        IntegerBinaryNode root = (IntegerBinaryNode) tree.getRoot();

        assertEquals(1, root.getLeft().getData());

        tree.add(value_3);
        assertEquals(3, root.getRight().getData());

        IntegerBinaryNode value__neg_1 = new IntegerBinaryNode(-1);
        tree.add(value__neg_1);

        assertEquals(value_1.hashCode(), tree.get(value_1.getData()).hashCode());
        assertEquals(value_2.hashCode(), tree.get(value_2.getData()).hashCode());
        assertEquals(value_3.hashCode(), tree.get(value_3.getData()).hashCode());
        assertEquals(value__neg_1.hashCode(), tree.get(value__neg_1.getData()).hashCode());
    }

    @Test
    public void deleteNode() {
        IntegerBinaryNode value_1 = new IntegerBinaryNode(1);
        IntegerBinaryNode value_neg_1 = new IntegerBinaryNode(-1);
        IntegerBinaryNode value_2 = new IntegerBinaryNode(2);
        IntegerBinaryNode value_3 = new IntegerBinaryNode(3);

        SimpleBinaryTree tree = new SimpleBinaryTree(value_2);
        tree.add(value_1);

        IntegerBinaryNode root = (IntegerBinaryNode) tree.getRoot();

        assertEquals(1, root.getLeft().getData());

        tree.add(value_3);
        assertEquals(3, root.getRight().getData());

        tree.add(value_neg_1);
        assertEquals(-1, root.getLeft().getLeft().getData());

        tree.delete(value_2);
        assertEquals(3, tree.getRoot().getData());
        assertEquals(1, ((BinaryNode)tree.getRoot()).getLeft().getData());
        assertEquals(-1, ((BinaryNode)tree.getRoot()).getLeft().getLeft().getData());
        assertEquals(null, ((BinaryNode)tree.getRoot()).getRight());
    }
    
}
