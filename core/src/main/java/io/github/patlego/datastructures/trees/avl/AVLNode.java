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
            left = ((AVLNode) this.getLeft()).getHeight() + 1;
        }

        if (this.getRight() != null) {
            right = ((AVLNode) this.getRight()).getHeight() + 1;
        }

        return (left - right);
    }
    
}
