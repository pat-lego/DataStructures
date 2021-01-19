package io.github.patlego.datastructures.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nonnull;

public abstract class BinaryTree<T> implements Tree {

    protected BinaryNode<T> root;

    public BinaryTree(BinaryNode<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("The node provided is null and must be defined in order to properly define a binary tree");
        }
        this.root = node;
    }

    public abstract @Nonnull Boolean add(@Nonnull BinaryNode<T> node);

    public abstract @Nonnull Boolean remove(@Nonnull BinaryNode<T> node);

    public List<BinaryNode<T>> getAllNodes(BinaryNode<T> start) {
        List<BinaryNode<T>> nodes = new LinkedList<>();
        if (start.hasChildren()) {
            if (start.getLeft() != null) {
                nodes.addAll(getAllNodes(start.getLeft()));
            }
            if (start.getRight() != null) {
                nodes.addAll(getAllNodes(start.getRight()));
            }
        } else {
            return Arrays.asList(start);
        }

        return nodes;
    }

    @Override
    public Integer size() {
        return this.getAllNodes(this.root).size();
    }
}
