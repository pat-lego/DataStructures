package io.github.patlego.datastructures.trees.avl;

import io.github.patlego.datastructures.trees.binary.BinaryNode;

public abstract class AVLNode<T> extends BinaryNode<T> {

    public AVLNode(T data) {
        super(data);
    }

    public Integer getHeight() {
        Integer left = 0;
        Integer right = 0;
        if (this.getLeft() == null && this.getRight() == null) {
            return 0;
        }

        if (this.getLeft() != null) {
            left = _getHeight((AVLNode) this.getLeft(), 1);
        }

        if (this.getRight() != null) {
            right = _getHeight((AVLNode) this.getRight(), 1);
        }

        return (left - right);
    }

    private Integer _getHeight(AVLNode node, Integer height) {

        Integer left = 0;
        Integer right = 0;

        if (node.getLeft() != null) {
            left = _getHeight((AVLNode) node.getLeft(), height + 1);
        }

        if (node.getRight() != null) {
            right = _getHeight((AVLNode) node.getRight(), height + 1);
        }

        if (left == 0 && right == 0) {
            return height;
        }

        if (left > right) {
            return left;
        }

        if (right > left) {
            return right;
        }

        return left;

    }

}
