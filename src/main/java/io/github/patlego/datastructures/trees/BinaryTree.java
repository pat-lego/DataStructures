package io.github.patlego.datastructures.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nonnull;

public abstract class BinaryTree<T> implements Tree {

    protected BinaryNode<T> root;

    public BinaryTree(BinaryNode<T> node) {
        if (node == null) {
            throw new IllegalArgumentException(
                    "The node provided is null and must be defined in order to properly define a binary tree");
        }
        this.root = node;
    }

    public Boolean add(BinaryNode<T> node) {
        BinaryNode<T> parent = this._add(node, this.root);

        if (parent.compareTo(node) < 0) {
            parent.setRight(node);
            return Boolean.TRUE;
        }

        if (parent.compareTo(node) > 0) {
            parent.setLeft(node);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    private BinaryNode _add(BinaryNode<T> node, BinaryNode<T> root) {
        if (root.hasChildren()) {
            if (root.compareTo(node) < 0) {
                if (root.getRight() != null) {
                    return _add(node, root.getRight());
                } else {
                    return root;
                }
            }
            if (root.compareTo(node) > 0) {
                if (root.getLeft() != null) {
                    return _add(node, root.getLeft());
                } else {
                    return root;
                }
            }
        }
        return root;
    }

    public abstract @Nonnull Boolean remove(@Nonnull BinaryNode<T> node);

    public List<BinaryNode<T>> getAllNodes() {
        return this._getAllNodes(this.root);
    }

    private List<BinaryNode<T>> _getAllNodes(BinaryNode<T> start) {
        List<BinaryNode<T>> nodes = new LinkedList<>();
        if (start.hasChildren()) {
            if (start.getLeft() != null) {
                nodes.addAll(_getAllNodes(start.getLeft()));
            }
            if (start.getRight() != null) {
                nodes.addAll(_getAllNodes(start.getRight()));
            }
        } else {
            // Found a leaf node
            return Arrays.asList(start);
        }

        // Add the parent
        nodes.add(start);
        return nodes;
    }

    @Override
    public Integer size() {
        return this.getAllNodes().size();
    }

    @Override
    public Node<T> getRoot() {
        return this.root;
    }

    @Override
    public <T> Boolean isRoot(Node<T> node) {
        return (this.root.compareTo(node) == 0);
    }
}
