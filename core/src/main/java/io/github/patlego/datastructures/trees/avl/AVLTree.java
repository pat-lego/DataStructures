package io.github.patlego.datastructures.trees.avl;

import io.github.patlego.datastructures.trees.binary.BinaryTree;

public abstract class AVLTree extends BinaryTree {

    public AVLTree(AVLNode node) {
        super(node);
    }

    protected Boolean add(AVLNode node) {
        if (super.add(node)) {
            rebalance();
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    protected Boolean delete(AVLNode node) {
        if (super.delete(node)) {
            rebalance();
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    protected Boolean isOffBalance() {
        AVLNode root = (AVLNode) super.getRoot();
        return _isOffBalance(root);
    }

    private Boolean _isOffBalance(AVLNode node) {

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

    protected Boolean isNodeOffBalance(AVLNode node) {
        if (node.getHeight() > 1) {
            return Boolean.TRUE;
        }

        if (node.getHeight() < -1) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    protected AVLNode getOffBalanceNode() {
        AVLNode root = (AVLNode) this.getRoot();
        return this._getOffBalanceNode(root, null);
    }

    private AVLNode _getOffBalanceNode(AVLNode node, AVLNode offbalance) {
        if (isNodeOffBalance(node)) {
            if (node.getLeft() != null) {
                return _getOffBalanceNode((AVLNode) node.getLeft(), node);
            }

            if (node.getRight() != null) {
                return _getOffBalanceNode((AVLNode) node.getRight(), node);
            }
        }

        return offbalance;
    }

    protected void rebalance() {
    }

    protected void balance(AVLNode offbalance) {

    }

    protected void ll(AVLNode offbalance) {

    }

    protected void rr(AVLNode offbalance) {

    }

    protected void lr(AVLNode offbalance) {

    }

    protected void rl(AVLNode offbalance) {

    }

}
