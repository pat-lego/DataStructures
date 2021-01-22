package io.github.patlego.datastructures.trees.binary;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import io.github.patlego.datastructures.trees.Node;
import io.github.patlego.datastructures.trees.Tree;

public abstract class BinaryTree implements Tree {

    protected BinaryNode root;

    public BinaryTree(BinaryNode node) {
        if (node == null) {
            throw new IllegalArgumentException(
                    "The node provided is null and must be defined in order to properly define a binary tree");
        }
        this.root = node;
    }

    protected @Nonnull Boolean add(@Nonnull BinaryNode node) {
        BinaryNode parent = this._add(node, this.root);

        if (parent.compareTo(node.getData()) < 0) {
            parent.setRight(node);
            return Boolean.TRUE;
        }

        if (parent.compareTo(node.getData()) > 0) {
            parent.setLeft(node);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    private @Nonnull BinaryNode _add(@Nonnull BinaryNode node, @Nonnull BinaryNode root) {
        if (root.hasChildren()) {
            if (root.compareTo(node.getData()) < 0) {
                if (root.getRight() != null) {
                    return _add(node, root.getRight());
                } else {
                    return root;
                }
            }
            if (root.compareTo(node.getData()) > 0) {
                if (root.getLeft() != null) {
                    return _add(node, root.getLeft());
                } else {
                    return root;
                }
            }
        }
        return root;
    }

    protected @Nonnull Boolean delete(@Nonnull BinaryNode node) {
        if (node.hasChildren()) {
            // Node has 2 children
            if (node.getLeft() != null && node.getRight() != null) {
                BinaryNode min = findMin(node.getRight());

                Boolean removed = delete(min);
                BinaryNode parent = (BinaryNode) getParent(node);

                // Trying to delete root
                if (parent == null) {
                    if (node.getLeft() != null && node.getLeft().compareTo(min.getData()) != 0) {
                        min.setLeft(node.getLeft());
                    }

                    if (node.getRight() != null && node.getRight().compareTo(min.getData()) != 0) {
                        min.setRight(node.getLeft());
                    }
                    node = min;
                    root = min;
                    return removed && Boolean.TRUE;
                } else {
                    if (parent.getLeft().compareTo(node.getData()) == 0) {
                        parent.setLeft(min);
                        min.setLeft(node.getLeft());
                        min.setRight(node.getRight());
                        return removed && Boolean.TRUE;
                    }

                    if (parent.getRight().compareTo(node.getData()) == 0) {
                        parent.setRight(min);
                        min.setLeft(node.getLeft());
                        min.setRight(node.getRight());
                        return removed && Boolean.TRUE;
                    }
                }
            }

            // Node only has one child
            if (node.getLeft() != null) {
                BinaryNode parent = (BinaryNode) getParent(node);
                if (parent.getLeft().compareTo(node.getData()) == 0) {
                    parent.setLeft(node.getLeft());
                    return Boolean.TRUE;
                }

                if (parent.getRight().compareTo(node.getData()) == 0) {
                    parent.setRight(node.getLeft());
                    return Boolean.TRUE;
                }
            }

            if (node.getRight() != null) {
                BinaryNode parent = (BinaryNode) getParent(node);
                if (parent.getLeft().compareTo(node.getData()) == 0) {
                    parent.setLeft(node.getRight());
                }

                if (parent.getRight().compareTo(node.getData()) == 0) {
                    parent.setRight(node.getRight());
                }
            }

        } else {
            BinaryNode parent = (BinaryNode) getParent(node);
            if (parent != null) {
                if (parent.getLeft().compareTo(node.getData()) == 0) {
                    parent.setLeft(null);
                    return Boolean.TRUE;
                }

                if (parent.getRight().compareTo(node.getData()) == 0) {
                    parent.setRight(null);
                    return Boolean.TRUE;
                }
            }

        }

        return Boolean.FALSE;
    }

    protected @Nonnull BinaryNode findMin(@Nonnull BinaryNode node) {
        if (node.hasChildren()) {
            if (node.getLeft() != null) {
                return findMin(node.getLeft());
            }
        }
        return node;
    }

    protected @Nonnull BinaryNode findMax(@Nonnull BinaryNode node) {
        if (node.hasChildren()) {
            if (node.getRight() != null) {
                return findMax(node.getRight());
            }
        }
        return node;
    }

    protected @Nonnull Boolean exists(@Nonnull BinaryNode node) {
        return _exists(node, this.root);
    }

    private @Nonnull Boolean _exists(@Nonnull BinaryNode node, @Nonnull BinaryNode root) {
        if (node.compareTo(root.getData()) == 0) {
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

    protected @Nonnull List<BinaryNode> getAllNodes() {
        return this._getAllNodes(this.root);
    }

    private @Nonnull List<BinaryNode> _getAllNodes(@Nonnull BinaryNode start) {
        List<BinaryNode> nodes = new LinkedList<>();
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
    public @Nonnull Node getRoot() {
        return this.root;
    }

    @Override
    public <T> @Nonnull Boolean isRoot(@Nonnull Node<T> node) {
        if (node == null) {
            return Boolean.FALSE;
        }
        return (this.root.compareTo(node.getData()) == 0);
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

        Node<T> parent = null;
        if (root.hasChildren()) {
            if (root.getLeft() != null) {
                parent = Optional.ofNullable(_getParent(data, root.getLeft(), root)).orElse(parent);
            }

            if (root.getRight() != null) {
                parent = Optional.ofNullable(_getParent(data, root.getRight(), root)).orElse(parent);
            }
        }

        return parent;
    }
}
