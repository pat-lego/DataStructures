package io.github.patlego.datastructures.trees.avl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.IntSupplier;

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

    protected @Nullable AVLNode getMinOffBalanceNode() {
        AVLNode node = (AVLNode) this.getRoot();
        Set<AVLNode> offBalanced = new HashSet<AVLNode>();
        _getOffBalanceNode(node, offBalanced);
        //TODO find the deepest node in the tree that is off balanced, use the list of off balanced nodes to find it
        return null;
    }

    /**
     * This function will find all of the offBalanced nodes and return them in a list
     * @param node
     * @return
     */
    private @Nullable Set<AVLNode> _getOffBalanceNode(AVLNode node, Set<AVLNode> offBalanced) {
        if (this.isNodeOffBalance(node)) {
            offBalanced.add(node);
        }
        
        if (node.hasChildren()) {
            if (node.getLeft() != null) {
                offBalanced.addAll(_getOffBalanceNode((AVLNode) node.getLeft(), offBalanced));
            }

            if (node.getRight() != null) {
                offBalanced.addAll(_getOffBalanceNode((AVLNode) node.getRight(), offBalanced));

            }
        }

        return offBalanced;

    }

    protected void rebalance() {
        while (isOffBalance()) {
            AVLNode offBalance = getMinOffBalanceNode();
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
