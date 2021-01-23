package io.github.patlego.datastructures.trees.avl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

        Boolean left = Boolean.FALSE;
        Boolean right = Boolean.FALSE;
        if (node.getLeft() != null) {
            left =  _isOffBalance((AVLNode) node.getLeft());
        }

        if (node.getRight() != null) {
            right = _isOffBalance((AVLNode) node.getRight());
        }

        return left || right;
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

            offBalanceIndex.add(index);
        }

        Iterator<AVLNode> offBalancedIterator = offBalanced.iterator();
        Integer deepest = offBalanceIndex.get(0);
        AVLNode minBalanceNode = offBalanced.iterator().next();

        for (int i = 0; i < offBalanceIndex.size() && offBalancedIterator.hasNext(); i++) {
            AVLNode temp = offBalancedIterator.next();
            if (deepest < offBalanceIndex.get(i)) {
                minBalanceNode = temp;
                deepest = offBalanceIndex.get(i);
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
                Integer result = _getNodeIndex((AVLNode) root.getLeft(), node, index + 1);
                return result;
            }

            if (root.getRight() != null) {
                Integer result = _getNodeIndex((AVLNode) root.getRight(), node, index + 1);
                return result;
            }
        }

        return index;
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
        if (this.isRoot(offBalance)) {
            AVLNode newRoot = (AVLNode) offBalance.getLeft().getRight();
            newRoot.setLeft(offBalance.getLeft());
            root.getLeft().setRight(null);

            newRoot.setRight(offBalance);
            root.setLeft(null);

            root = newRoot;
            return;
        }

        AVLNode parent = (AVLNode) this.getParent(offBalance);
        if (parent.getLeft().compareTo(offBalance.getData()) == 0) {
            parent.setLeft(offBalance.getLeft().getRight());
            offBalance.getLeft().setRight(null);

            parent.getLeft().setRight(offBalance);
            parent.getLeft().setLeft(offBalance.getLeft());
            offBalance.setLeft(null);
        }

        if (parent.getRight().compareTo(offBalance.getData()) == 0) {
            parent.setRight(offBalance.getLeft().getRight());
            offBalance.getLeft().setRight(null);

            parent.getRight().setRight(offBalance);
            parent.getRight().setLeft(offBalance.getLeft());
            offBalance.setLeft(null);
        }
    }

    protected void rl(AVLNode offBalance) {
        if (this.isRoot(offBalance)) {
            AVLNode newRoot = (AVLNode) offBalance.getRight().getLeft();
            newRoot.setRight(offBalance.getRight());
            root.getRight().setLeft(null);

            newRoot.setLeft(offBalance);
            root.setRight(null);

            root = newRoot;
            return;
        }

        AVLNode parent = (AVLNode) this.getParent(offBalance);
        if (parent.getLeft().compareTo(offBalance.getData()) == 0) {
            parent.setLeft(offBalance.getRight().getLeft());
            offBalance.getRight().setLeft(null);

            parent.getLeft().setLeft(offBalance);
            parent.getLeft().setRight(offBalance.getRight());
            offBalance.setRight(null);
        }

        if (parent.getRight().compareTo(offBalance.getData()) == 0) {
            parent.setRight(offBalance.getRight().getLeft());
            offBalance.getRight().setLeft(null);

            parent.getRight().setLeft(offBalance);
            parent.getRight().setRight(offBalance.getRight());
            offBalance.setRight(null);
        }

    }

}
