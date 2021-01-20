package io.github.patlego.datastructures.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class BinaryTree<T> implements Tree {

    protected BinaryNode<T> root;

    public BinaryTree(BinaryNode<T> node) {
        if (node == null) {
            throw new IllegalArgumentException(
                    "The node provided is null and must be defined in order to properly define a binary tree");
        }
        this.root = node;
    }

    public @Nonnull Boolean add(@Nonnull BinaryNode<T> node) {
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

    private @Nonnull BinaryNode _add(@Nonnull BinaryNode<T> node, @Nonnull BinaryNode<T> root) {
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

    public abstract Boolean remove(@Nonnull BinaryNode<T> node);

    public @Nonnull Boolean exists(@Nonnull BinaryNode<T> node) {
        return _exists(node, this.root);
    }

    private @Nonnull Boolean _exists(@Nonnull BinaryNode<T> node, @Nonnull BinaryNode root) {
        if (node.compareTo(root) == 0) {
            return Boolean.TRUE;
        }
        Boolean left = Boolean.FALSE;
        Boolean right = Boolean.FALSE;

        if (root.hasChildren()) {
            if (root.getLeft() != null) {
                left = _exists(node, root.getLeft());
            }

            if (root.getRight() != null) {
                right = _exists(node, root.getRight());
            }
        }

        return (left || right);
    }

    public @Nonnull List<BinaryNode<T>> getAllNodes() {
        return this._getAllNodes(this.root);
    }

    private @Nonnull List<BinaryNode<T>> _getAllNodes(@Nonnull BinaryNode<T> start) {
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
    public @Nonnegative @Nonnull Integer size() {
        return this.getAllNodes().size();
    }

    @Override
    public @Nonnull Node<T> getRoot() {
        return this.root;
    }

    @Override
    public <T> @Nonnull Boolean isRoot(@Nonnull Node<T> node) {
        if (node == null) {
            return Boolean.FALSE;
        }
        return (this.root.compareTo(node) == 0);
    }

    @Override
    public <T> @Nonnull Boolean hasParent(@Nonnull Node<T> node) {
        return isRoot(node);
    }

    @Override
    public <T> @Nullable Node<T> getParent(@Nonnull Node<T> node) {
        return _getParent(node.getData(), this.root, null);
    }

    private <T> @Nullable Node<T> _getParent(@Nonnull T data, @Nonnull BinaryNode root, @Nullable BinaryNode previous) {
        if (root.compareTo(data) == 0) {
            return previous;
        }

        if (root.hasChildren()) {
            if (root.getLeft() != null) {
                return _getParent(data, root.getLeft(), root);
            }

            if (root.getRight() != null) {
                return _getParent(data, root.getRight(), root);
            }
        }

        return null;
    }
}
