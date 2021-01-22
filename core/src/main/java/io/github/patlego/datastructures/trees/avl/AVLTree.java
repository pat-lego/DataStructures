package io.github.patlego.datastructures.trees.avl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import io.github.patlego.datastructures.trees.binary.BinaryTree;

public abstract class AVLTree extends BinaryTree {

    public AVLTree(@Nonnull AVLNode node) {
        super(node);
    }

    protected @Nonnull Boolean add(@Nullable AVLNode node) {
        if (super.add(node)) {
            rebalance();
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    protected @Nonnull Boolean delete(@Nullable AVLNode node) {
        if (super.delete(node)) {
            rebalance();
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    protected @Nonnull Boolean isOffBalance() {
        AVLNode root = (AVLNode) super.getRoot();
        return _isOffBalance(root);
    }

    private @Nonnull Boolean _isOffBalance(@Nonnull AVLNode node) {

        if (isNodeOffBalance(node)) {
            return Boolean.TRUE;
        }

        if (node.getLeft() != null) {
            return _isOffBalance((AVLNode) node.getLeft());
        }

        if (node.getRight() != null) {
            return _isOffBalance((AVLNode) node.getRight());
        }

        return Boolean.FALSE;
    }

    protected @Nonnull Boolean isNodeOffBalance(@Nullable AVLNode node) {
        if (node == null) {
            return Boolean.FALSE;
        }

        if (node.getHeight() > 1) {
            return Boolean.TRUE;
        }

        if (node.getHeight() < -1) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    protected @Nullable AVLNode getOffBalanceNode() {
        AVLNode node = (AVLNode) this.getRoot();
        if (this.isNodeOffBalance(node)) {
            return _getOffBalanceNode(node, node, new HashSet<AVLNode>() );
        }

        return null;
    }

    protected @Nullable AVLNode _getOffBalanceNode(AVLNode node, AVLNode offbalance, Set<AVLNode> previous) {
        // We passed the last node that was offbalanced
        if (!this.isNodeOffBalance(node)) {
            AVLNode invalidHeight = (AVLNode) this.getParent(node);
            if (node.compareTo(invalidHeight.getData()) != 0 && !previous.contains(invalidHeight)) {
                previous.add(offbalance);
                offbalance = invalidHeight;
                return offbalance;
            }
        }

        if (node.getLeft() != null) {
            offbalance = _getOffBalanceNode((AVLNode) node.getLeft(), offbalance, previous);
        }

        if (node.getRight() != null) {
            offbalance = _getOffBalanceNode((AVLNode) node.getRight(), offbalance, previous);
        }

        return offbalance;
    }

    protected void rebalance() {
        while (isOffBalance()) {
            AVLNode offBalance = getOffBalanceNode();
            balance(offBalance);
        }
    }

    protected void balance(AVLNode offBalance) {
        if (offBalance.getHeight() == 2) {
            if (((AVLNode) offBalance.getLeft()).getHeight() == 1) {
                ll(offBalance);
            } else {
                lr(offBalance);
            }
        }

        if (offBalance.getHeight() == -2) {
            if (((AVLNode) offBalance.getRight()).getHeight() == -1) {
                rr(offBalance);
            } else {
                rl(offBalance);
            }
        }
    }

    protected void ll(AVLNode offBalance) {
        // Trying to remove root
        if (this.isRoot(offBalance)) {
            root = offBalance.getLeft();
            root.setRight(offBalance);
            root.getRight().setLeft(null);
            return;
        }

        AVLNode parent = (AVLNode) this.getParent(offBalance);
        parent.setLeft(offBalance.getLeft());
        offBalance.getLeft().setRight(offBalance);
        offBalance.setLeft(null);
        offBalance.setRight(null);
    }

    protected void rr(AVLNode offBalance) {
        // Trying to remove root
        if (this.isRoot(offBalance)) {
            root = offBalance.getRight();
            root.setLeft(offBalance);
            root.getLeft().setRight(null);
            return;
        }

        AVLNode parent = (AVLNode) this.getParent(offBalance);
        parent.setRight(offBalance.getRight());
        offBalance.getRight().setLeft(offBalance);
        offBalance.setLeft(null);
        offBalance.setRight(null);
    }

    protected void lr(AVLNode offBalance) {

    }

    protected void rl(AVLNode offBalance) {

    }

}
