package io.github.patlego.datastructures.trees;

import java.util.List;

import javax.annotation.Nonnull;

public abstract class BinaryTree implements Tree {

    protected Node root;

    public <T> BinaryTree(Node<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("The node provided is null and must be defined in order to properly define a binary tree");
        }
        this.root = node;
    }

    public abstract @Nonnull <T> Boolean add(@Nonnull Node<T> node);

    public abstract @Nonnull <T> Boolean remove(@Nonnull Node<T> node);

    public abstract @Nonnull <T> List<Node<T>> getAllNodes(Node<T> start);

    @Override
    public <T> Boolean isRoot(Node<T> node) {
        if (node == null) {
            return Boolean.FALSE;
        }

        return node.hasParent();
    }

    @Override
    public <T> Node<T> getRoot() {
        return root;
    }

    @Override
    public Integer size() {
        return this.getAllNodes(this.root).size();
    }
}
