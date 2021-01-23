package io.github.patlego.datastructures.trees.avl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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

        if (offBalanced.isEmpty()) {
            return null;
        }

        List<Integer> offBalanceIndex = new ArrayList<Integer>();
        for (AVLNode offBalance : offBalanced) {
            Integer index = _getNodeIndex((AVLNode) this.getRoot(), offBalance, 0);

            if (index != null) {
                offBalanceIndex.add(index);
            }
        }

        Iterator<AVLNode> offBalancedIterator = offBalanced.iterator();
        Integer deepest = offBalanceIndex.get(0);
        AVLNode minBalanceNode = offBalanced.iterator().next();

        for (int i = 0; i < offBalanceIndex.size() && offBalancedIterator.hasNext(); i++) {
            AVLNode temp = offBalancedIterator.next();
            if (deepest > offBalanceIndex.get(0)) {
                minBalanceNode = temp;
            }
        }

        return minBalanceNode;
    }

    private Integer _getNodeIndex(AVLNode root, AVLNode node, Integer index) {
        if (root.compareTo(node.getData()) == 0) {
            return index;
        }

        if (root.hasChildren()) {
            if (root.getLeft() != null) {
                return _getNodeIndex((AVLNode) root.getLeft(), node, index + 1);
            }

            if (root.getRight() != null) {
                return _getNodeIndex((AVLNode) root.getRight(), node, index + 1);
            }
        }

        return null;
    }

    /**
     * This function will find all of the offBalanced nodes and return them in a
     * list
     * 
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
