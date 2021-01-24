package io.github.patlego.datastructures.trees.binary;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import io.github.patlego.datastructures.trees.Node;

public abstract class BinaryNode<T> implements Node<T> {

    private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	private T data;

	public BinaryNode(@Nonnull T data) {
		if (data == null) {
			throw new IllegalArgumentException("Cannot have a null data parameter provided to the Binary Node");
		}

		this.data = data;
	}
    
	@Override
	public @Nonnull Boolean hasChildren() {
		if (left != null) {
            return Boolean.TRUE;
        }

        if (right != null) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
    
	@Override
	public @Nonnull List<Node<T>> getChildren() {
        return Arrays.asList(left, right);
    }
    
	@Override
	public @Nonnegative @Nonnull Integer size() {
        Integer size = 1;
        if (left != null) {
            size = size + 1;
        }

        if (right != null) {
            size = size + 1;
        }

        return size;
    }

	@Override
	public @Nonnull T getData() {
		return this.data;
    }
    
    public @Nullable BinaryNode<T> getLeft() {
        return this.left;
    }

    public @Nullable BinaryNode<T> getRight() {
        return this.right;
    }

    public void setLeft(@Nonnull BinaryNode<T> left) {
        this.left = left;
    }

    public void setRight(@Nonnull BinaryNode<T> right) {
        this.right = right;
    }
    
}
